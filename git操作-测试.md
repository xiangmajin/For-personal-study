# 企业级 Git 开发全流程（从组长建项目到新人上线）

以「你刚入职 XX 公司，组长创建了`company-project`项目」为起点，覆盖**远程分支初始化→本地开发→PR 审核→版本发布→线上 bug 修复**全链路，明确每一步的「本地 / 远程分支状态」。

## 一、阶段 1：组长初始化远程项目（企业项目起点）

### 组长操作：创建远程仓库及核心分支

组长在 GitLab/GitHub 创建**私有远程仓库`company-project`**，并初始化 2 个受保护分支（企业必配权限：普通开发者无法直接推送 / 修改这两个分支）：

- **远程分支 1：`main`**：生产分支（仅存放可上线的稳定代码）；
- **远程分支 2：`dev`**：开发分支（团队协作的主分支，整合所有功能代码）；

此时**远程仓库分支状态**：

plaintext











```plaintext
远程仓库company-project
├─ 受保护分支：main
└─ 受保护分支：dev
```

组长将你添加为项目「协作者」（你获得仓库的代码拉取 / 功能分支推送权限）。

## 二、阶段 2：你入职后首次克隆项目到本地

### 步骤 1：克隆远程仓库到本地

在你本地的工作目录（如`D:\workspace`）执行克隆命令：

bash



运行









```bash
# 克隆远程仓库（SSH方式，企业标配）
git clone git@gitlab.com:公司组名/company-project.git
```

克隆完成后，**本地 + 远程分支状态**：

- 本地分支：仅自动创建`main`分支（跟踪远程`origin/main`）；
- 远程分支：本地能看到`origin/main`、`origin/dev`（但本地未创建`dev`的跟踪分支）。

### 步骤 2：拉取`dev`分支到本地（建立跟踪关系）

企业开发以`dev`为协作主分支，需将远程`dev`拉到本地并绑定：

bash



运行









```bash
# 进入本地仓库根目录
cd company-project

# 拉取远程所有分支的最新信息
git fetch origin

# 创建本地dev分支，跟踪远程origin/dev
git checkout -b dev origin/dev
```

此时**本地分支状态**：

plaintext











```plaintext
本地仓库company-project
├─ main（跟踪origin/main）
└─ dev（跟踪origin/dev）
```

## 三、阶段 3：日常功能开发（企业核心流程）

以「开发「用户注册」功能」为例，覆盖从开发到合并的全流程。

### 步骤 1：同步`dev`最新代码（每天开发前必做）

确保本地`dev`是团队最新版本：

bash



运行









```bash
# 切换到本地dev分支
git checkout dev

# 拉取远程dev的最新代码（同步同事的修改）
git pull origin dev
```

### 步骤 2：创建个人功能分支（本地 + 远程）

从`dev`分支创建功能分支（命名规范：`feature/功能名`）：

bash



运行









```bash
# 创建并切换到功能分支（本地）
git checkout -b feature/user-register

# 推送本地功能分支到远程（建立跟踪关系）
git push -u origin feature/user-register
```

此时**本地 + 远程分支状态**：

- 本地：新增`feature/user-register`；
- 远程：新增`origin/feature/user-register`（你的专属功能分支）。

### 步骤 3：开发代码并提交

在本地`feature/user-register`分支开发「用户注册」代码，完成后提交：

bash



运行









```bash
# 暂存所有修改
git add .

# 提交到本地仓库（备注规范：类型: 内容）
git commit -m "feat: 完成用户注册功能（含手机号验证）"

# 推送本地提交到远程功能分支（同步进度）
git push
```

### 步骤 4：提 PR（合并请求）到`dev`分支（企业审核必经）

1. 打开 GitLab/GitHub 的远程仓库页面，找到你的`feature/user-register`分支；
2. 点击「创建 PR/MR」，选择**源分支：feature/user-register → 目标分支：dev**；
3. 填写 PR 说明（如 “用户注册功能开发完成，含手机号格式验证”），**@你的组长**审核。

### 步骤 5：组长审核并合并 PR

- 组长审核代码：若有问题，你在本地`feature/user-register`分支修改后重新`git push`（PR 会自动更新）；
- 审核通过后，组长点击「合并 PR」，你的功能代码被合并到**远程`dev`分支**。

### 步骤 6：同步`dev`并清理分支（功能上线后）

PR 合并后，你的功能代码已在`dev`中，需清理本地 / 远程的功能分支：

bash



运行









```bash
# 切换回本地dev分支，拉取合并后的最新代码
git checkout dev
git pull origin dev

# 删除本地功能分支
git branch -d feature/user-register

# 删除远程功能分支
git push origin --delete feature/user-register
```

## 四、阶段 4：线上 bug 修复（紧急场景）

若`main`分支（生产环境）出现 bug，需从`main`创建热修复分支：

### 步骤 1：从远程`main`创建 hotfix 分支

bash



运行









```bash
# 切换到本地main分支，拉取生产环境最新代码
git checkout main
git pull origin main

# 创建并切换到热修复分支（命名规范：hotfix/bug名）
git checkout -b hotfix/login-error

# 推送远程
git push -u origin hotfix/login-error
```

### 步骤 2：修复 bug 并提 PR

修复后提交代码，提 PR 到**远程`main`（生产）和`dev`（开发）分支**（需同时合并到两个分支，避免后续重复出现 bug）。

### 步骤 3：合并 PR 并清理分支

审核通过后，bug 代码合并到`main`和`dev`，清理 hotfix 分支：

bash



运行









```bash
# 同步main和dev的最新代码
git checkout main && git pull origin main
git checkout dev && git pull origin dev

# 删除本地+远程hotfix分支
git branch -d hotfix/login-error
git push origin --delete hotfix/login-error
```

## 五、阶段 5：版本发布（上线生产环境）

当`dev`分支功能全部测试通过后，发布到`main`（生产）：

### 步骤 1：提 PR 从`dev`合并到`main`

由组长 / 技术负责人提 PR，选择**源分支：dev → 目标分支：main**（企业级审核，需测试、产品共同确认）。

### 步骤 2：打版本标签（标记生产版本）

合并到`main`后，打标签（如`v1.0.0`）记录生产版本：

bash



运行









```bash
# 切换到main分支，拉取最新代码
git checkout main
git pull origin main

# 打标签
git tag v1.0.0

# 推送标签到远程
git push origin v1.0.0
```

### 步骤 3：部署`main`分支到生产环境

运维团队从远程`main`分支拉取`v1.0.0`版本代码，部署到生产服务器。

## 企业 Git 流程核心规则总结

1. **分支隔离**：`main`（生产）、`dev`（开发）、`feature`（个人功能）、`hotfix`（紧急修复）严格区分；
2. **权限管控**：`main`/`dev`为受保护分支，仅负责人可合并；
3. **审核必走**：所有代码合并到`dev`/`main`必须通过 PR 审核；
4. **每日同步**：开发前拉取`dev`，推送前拉取`dev`，避免代码冲突。