<template>
    <el-container>
        <!-- 左侧 -->
          <el-aside width="200px">
            <img src="../assets/loginBox.svg">
            <p class="imgTitle">
                欢迎使用动力云客系统
            </p>
        </el-aside>
        <!-- 右侧 -->
        <el-main>
            <div class="loginTitle">欢迎登录</div>
            <el-form ref="loginRefForm" :model="user" label-width="120px":rules="loginRules">
                <el-form-item label="账号" prop="loginAct">
                    <el-input v-model="user.loginAct" />
                </el-form-item>

                <el-form-item label="密码" prop="loginPwd">
                    <el-input type="password" v-model="user.loginPwd" />
                </el-form-item>

                

                <el-form-item>
                    <el-button type="primary" @click="login">登 录</el-button>
                </el-form-item>

                <el-form-item>
                    <el-checkbox label="记住我" name="rememberMe"></el-checkbox>
                </el-form-item>
                
            </el-form>
        </el-main>
    </el-container>
</template>


<script>
import { defineComponent } from 'vue'
import { doPost } from '../http/httpRequest'

export default defineComponent({
  name: 'LoginView',
  //定义页面使用到的变量,定义初始值为空
  data(){
    return{
        //对象变量定义是{}
        user:{ },
        //字符串变量定义‘’
        name : '',
        //数字变量定义，0
        age : 0,
        //数组变量定义[]
        arr : [],
        //list集合对象[{}]
        userList:[{}],
        // 定义表单,定义规则
        loginRules:{
            // 定义账号的验证规则，规则可以有多个，所以是数组
            loginAct:[
                { required: true, message: '请输入登录账号', trigger: 'blur' },
            ],
            // 定义账号的验证规则，规则可以有多个，所以是数组
            loginPwd:[
                { required: true, message: '请输入登录密码', trigger: 'blur' },
                { min:6, max : 16, message: '登录密码长度为6-16位', trigger: 'blur' }
            ]
        }
    }
  },
// 页面上需要使用功能的js函数，都在methods属性中定义
  methods:{
    // 登录函数
    login() {
        // 提交前保证输入框的合法性
        this.$refs.loginRefForm.validate((isValid) =>{
            // isValid是验证后的结果，如果是true表示验证通过，否则未通过
            if (isValid) {
                // 验证通过，可以提交登录
                let formData = new FormData();
                formData.append("loginAct", this.user.loginAct);
                formData.append("loginPwd", this.user.loginPwd);

                doPost("/api/login", formData).then((rep) => {
                    console.log(resp);
                    if (resp.data.code === 200){
                        //登录成功
                        messageTip("登录成功", "success");
                        //跳转到系统的主页面
                        window.location.href = "/dashboard";
                    } else {
                        //登录失败
                        messageTip("登录失败", "error");
                    }
                });
            }
        })
    }
  }
})

</script>



<style scoped>
.el-aside{
    background: #000;
    width:40%;
    text-align: center;
}
.el-main {
    height: calc(100vh);
}
img {
    height: 400px;
}
.imgTitle{
    color: #f9f9f9;
    font-size: 28px;
}
.el-form{
    width: 60%;
    /* 左右边距自动 */
    margin: auto;
}
.loginTitle{
    text-align: center;
    margin-top: 100px;
    margin-bottom: 25px;
    font-weight: bold;
}
.el-button{
    width: 100%;
}
</style>
