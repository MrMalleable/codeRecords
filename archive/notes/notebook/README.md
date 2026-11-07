### Introduction
**这个仓库主要是用于记录在看算法导论的期间个人做的笔记**

### 目的
提高自己对于算法和数据结构的理解和掌握，养成思考和分析问题的好习惯

### 要求
每天上传自己的看书笔记，不要求内容多少，不要求看书进度，只是自己每天都要有自己的收获，真正地能够去多思考蕴藏其中的那种分析问题和解决问题的方法。

### 时间
目前暂定15天，万事开头难，所以我们为什么不以15天来挑战一下自己？

### 打卡奖励
自给自足，放松也很重要哈哈。

### 鸡汤
Talk is cheap, show me the code.

---
关于如何使用git将本地文件上传到本仓库的步骤：

可参考：[Creating a pull request](https://help.github.com/articles/creating-a-pull-request/)

1. 在浏览器中输入以下地址:

`https://github.com/MrMalleable/notebook.git`

2. Fork本项目

3. 在本地打开git bash（假设已经安装好Git）,执行以下指令：

`
git clone https://github.com/MrMalleable/notebook.git
`

4. 切换到该目录

`
cd notebook
`

5. 创建自己的markdown文件或者其他文件并编辑，或者修改已存在的文件，保存好之后上传到远程仓库。

`
git commit -a -m "Add: balalabla"
git push -u origin master
`

6. 在浏览器中进入自己的github主页，找到你已fork的本项目，点击new pull request进入pull request界面确认提交的更改，确认无误后，开始填写本次提交的说明。

7. 点击create pull request来填写说明，填写好之后确认即可，等待原作者merge即可。

---
关于如何更新Fork项目的最新代码：

可参考：[Syncing a fork](https://help.github.com/articles/syncing-a-fork/)

1. 切换到本地的工程目录：

`
cd notebook
`

2. 将你fork的项目的最新文件先抓过来

`
git fetch notebook
`

3. 切换到master分支

`
git checkout master
`

4. 将最新项目的master分支和本地的master分支相结合

`
git merge notebook/master
`

---
ChangeLog:

2017/10/16 暂且先想到这么多，欢迎补充，以上若有错误，欢迎联系970014590@qq.com.

2017/10/20 要更新本地的文件与远程仓库的文件相同，在工作目录下直接使用**git pull**即可。

2017/10/24
### 关于设置windows下git bash中alias永久生效的方法：
alias就是别名的意思。
- Why we create alias?
 1. 因为很多时候我们可能要输入一串很长的命令，而且如果这个命令用的很多的话，会觉得很烦。如果每次输入的命令都是相同的或者前面大部分都是相同的，我们就可以用一个我们自己容易记的比较短的命令来代表刚才那一串长的命令。
 
- How to use?
 1. 举个栗子：`git commit -a -m "xxxx"` 可以这样设置：`alias gc='git commit -a -m'`, 然后我们就可以这样使用：`gc "xxxx"`
 从以上看出设置别名可以让我们省去很多输入命令特别是繁琐命令的时间，但是前提是自己要记得设置的别名是什么？

- notes:
 1. 查看设置好的别名：如果在命令行窗口设置别名的话只能在当前窗口生效，一旦关闭重新打开的话就会失效，我们可以在命令行下输入`alias`查看已经设置好的别名。
 2. 永久生效问题：找到安装文件下的etc/profile.d/aliased.sh,打开并在里面添加你要设置的别名，保存退出。这时你输入`alias`查看别名发现刚才设置的是还没有生效的，必须在命令行中输入`source aliases.sh`才会使刚才的设置生效。在这个文件里面提到了可以设置自己的.bashrc文件或者是.bash_profile文件来设置别名，这就和linux系统比较相似了。
 3. 删除别名：`unalias + 已经设置好的别名`

2017/10/24
### 关于如何避免在push时重复输入用户名和密码：[最新解决](http://www.jianshu.com/p/2800dfbcdc04)

Notes:
```
以下指令可能会用到：
1. 执行以下指令可以在系统文件夹中.gitconfig中看到`[credential] helper = store`
git config --global credential.helper store

2.在改用ssh方式后第一次git push可能会警告，根据警告信息会用到以下指令：
git config --global push.default simple
git push --set-upstream origin master
```
