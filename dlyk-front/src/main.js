//import ... from ...语句导入，从vue框架导入createApp函数
import { createApp } from 'vue'
//导入css样式，不需要from语句
// import './style.css'

//import ... from ...语句导入，从vue框架导入elementplus 组件
import ElementPlus from 'element-plus'

//导入element-plus的css样式，不需要from语句
import 'element-plus/dist/index.css'

// 注册所有图标
import * as ElementPlusIconsVue from '@element-plus/icons-vue'

//从router.js中导入router组件
import router from './router/router.js'

//从./App.vue页面导入App组件（一般文件名叫啥组件名就叫啥）
import App from './App.vue'//根组件

//循环注册
let app = createApp(App);
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
  }

//利用上面所导入的createApp()函数，创建vue应用，使用组件，mount挂载（最后）
app.use(ElementPlus).use(router).mount('#app')
