<template>
    <body class = "login_bg">
        <div class = "login_container">
            <el-form ref="LoginForm" :model="LoginForm" label-width="80px">
                 <h2 class = "login_title">登录</h2>
                 <el-form-item label="用户名">
                    <el-input v-model="LoginForm.username"></el-input>
                 </el-form-item>
                 <el-form-item label="密码">
                    <el-input v-model="LoginForm.password"></el-input>
                 </el-form-item>
                 <el-form-item>
                    <el-button type="primary" @click = "login">登录</el-button>
                    <el-button @click = "goToRegist">注册</el-button>
                 </el-form-item>
            </el-form>
        </div>
    </body>    
</template>

<script>
    export default {
        name: 'Login',
        data() { 
            return {
                LoginForm: {
                    username: '',
                    password: ''
                }
            }
        },
        methods: {
            // 登录
            login(){
                this.$axios.post('/login', {
                    username: this.LoginForm.username,
                    password: this.LoginForm.password
                }).then(successResponse => {
                    // 后端发送过来的是 Result 类型数据，判断 Result.code 即可
                    if(successResponse.data.code === 200){
                        this.$alert(successResponse.data.message, '🎉 Successful', {
                            confirmButtonText: '确定'
                        })  
                        this.$router.replace({path: '/index'})
                    } else {
                        this.$alert(successResponse.data.message, '😔 Failed', {
                            confirmButtonText: '确定'
                        })

                    }
                }).catch(failResponse => {

                })
            },
            // 进入 regist 界面
            goToRegist(){
                this.$router.replace({path: '/regist'})
            }
        }
    }
</script>

<style scoped>
    .login_container {
        border-radius: 20px;
        background-clip: padding-box;
        margin: 130px auto;
        width: 400px;
        padding: 35px 65px 15px 0px;
        background: #fff;
        border: 1px solid #cfc9c9;
    }
    .login_title {
        margin: 0px 0px 40px 75px;
        text-align: center;
        color: #505458;
        font-size: 32px;
    }
</style>