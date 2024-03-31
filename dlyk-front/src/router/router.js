//从依赖库vue-router导入函数createRouter, createWebHistory
import { createRouter, createWebHistory } from "vue-router";

//定义一个变量
let router = createRouter({
    //路由历史
    history:createWebHistory(),

    //配置路由，一个数组，里面可以配置多个路由
    routes:[
        {
            //路由路径
            path:'/',
            //路由路径所对应的页面
            component : () => import('../view/LoginView.vue'),
        },
        {
            //路由路径
            path:'/dashboard',
            //路由路径所对应的页面
            component : () => import('../view/DashboardView.vue'),
        },
    ]
})
//导出创建的路由对象
export default router;