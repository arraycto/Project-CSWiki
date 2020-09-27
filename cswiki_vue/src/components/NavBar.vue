<template>
    <div class = "navBar">
        <el-menu 
         class="el-menu-demo" mode="horizontal" @select="handleSelect"
        >
            <el-menu-item index = "1">
                <img class = "img" src = "https://gitee.com/veal98/images/raw/master/img/LogoMakr_6eL1ki.png" >
            </el-menu-item>
            <el-menu-item index="5" style = "float: right; right: 0.5%"><a href="/regist">✍ 注册</a></el-menu-item>
            <el-menu-item index="6" style = "float: right;"><a href="/login">📡 登录</a></el-menu-item>
            <el-menu-item index="4" style = "float: right;"><a href="/admin">🎅 个人中心</a></el-menu-item>
            <el-menu-item index="3" style = "float: right;"><a href="/notebook">📖 笔记本</a></el-menu-item>
            <el-menu-item index="2" style = "float: right;"><a href="/index">🚀 首页</a></el-menu-item>

            
        </el-menu>
        <div class="line"></div>
    </div>
</template>

<script>
    export default {
        
        name: 'NavBar',
        data(){
            return {
            }
        }
    }
</script>

<style>
    a{
        text-decoration: none;
        font-size: 16px;
        font-weight: bold
    }
    img{
        height: 50px;
        padding-bottom: 5px;
    }
</style>