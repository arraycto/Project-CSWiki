<template>
    <body class = "regist_bg">
        <div class = "regist_container">
            <el-form ref="RegistForm" :model="RegistForm" label-width="80px">
                 <h2 class = "regist_title">注册</h2>
                 <el-form-item label="用户名">
                    <el-input v-model="RegistForm.username"></el-input>
                 </el-form-item>
                 <el-form-item label="密码">
                    <el-input v-model="RegistForm.password"></el-input>
                 </el-form-item>
                 <el-form-item label="邮箱">
                    <el-input v-model="RegistForm.email"></el-input>
                 </el-form-item>
                 <el-form-item>
                    <el-button type="primary" @click = "regist">注册</el-button>
                    <el-button @click = "goToLogin">登录</el-button>
                 </el-form-item>
            </el-form>
        </div>
    </body>    
</template>

<script>
    export default {
        name: 'Regist',
        data() { 
            return {
                RegistForm: {
                    username: '',
                    password: '',
                    email: ''
                }
            }
        },
        methods: {
            // 注册
            regist(){
                this.$axios.post('/regist', {
                    username: this.RegistForm.username,
                    password: this.RegistForm.password,
                    email: this.RegistForm.email
                }).then(successResponse => {
                    // 后端发送过来的是 Result 类型数据，判断 Result.code 即可
                    if(successResponse.data.code === 200){
                        // 注册成功进入登录界面
                        this.$alert(successResponse.data.message, '🎉 Successful', {
                            confirmButtonText: '确定'
                        })
                        this.$router.replace({path: '/login'}) 
                    } else {
                        this.$alert(successResponse.data.message, '😔 Failed', {
                            confirmButtonText: '确定'
                        })

                    }
                }).catch(failResponse => {

                })
            },
            // 进入 Login 界面
            goToLogin(){
                this.$router.replace({path: '/login'})
            }
        }
    }
</script>

<style scoped>
    .regist_container {
        border-radius: 20px;
        background-clip: padding-box;
        margin: 130px auto;
        width: 400px;
        padding: 35px 65px 15px 0px;
        background: #fff;
        border: 1px solid #cfc9c9;
    }
    .regist_title {
        margin: 0px 0px 40px 75px;
        text-align: center;
        color: #3a8cdf;
        font-size: 32px;
    }
</style>