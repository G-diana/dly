<template>
  <el-container>
    <!-- 左侧 -->
    <el-aside :width="isCollapse ? '64px' : '200px'">
      <div class="menuTitle">@动力云客管理系统</div>
      <el-menu 
        active-text-color="#ffd04b" 
        background-color="#334157" 
        class="el-menu-vertical-demo" 
        default-active="2"
        text-color="#fff" 
        style="border-right:solid 0px"
        :collapse = "isCollapse"
        :collapse-transition = "false"
        :unique-opened = "true">

        <!-- 市场活动菜单 -->
        <el-sub-menu index="1">
          <template #title>
            <el-icon><OfficeBuilding /></el-icon>
            <span>市场活动</span>
          </template>
          <el-menu-item index="1-1">市场活动</el-menu-item>
          <el-menu-item index="1-2">市场管理</el-menu-item>
        </el-sub-menu>

        <!-- 线索管理 -->
        <el-sub-menu index="2">
          <template #title>
            <el-icon><Operation /></el-icon>
            <span>线索管理</span>
          </template>
          <el-menu-item index="1-1">线索管理</el-menu-item>
        </el-sub-menu>

        <!-- 客户管理 -->
        <el-sub-menu index="3">
          <template #title>
            <el-icon>
              <location />
            </el-icon>
            <span>客户管理</span>
          </template>
          <el-menu-item index="1-1">客户管理</el-menu-item>
          <el-menu-item index="1-2">客户统计</el-menu-item>
        </el-sub-menu>

        <!-- 交易管理 -->
        <el-sub-menu index="4">
          <template #title>
            <el-icon>
              <location />
            </el-icon>
            <span>交易管理</span>
          </template>
          <el-menu-item index="1-1">交易管理</el-menu-item>
        </el-sub-menu>

        <!-- 产品管理 -->
        <el-sub-menu index="5">
          <template #title>
            <el-icon>
              <location />
            </el-icon>
            <span>产品管理</span>
          </template>
          <el-menu-item index="1-1">产品管理</el-menu-item>
        </el-sub-menu>

        <!-- 字典管理 -->
        <el-sub-menu index="6">
          <template #title>
            <el-icon>
              <location />
            </el-icon>
            <span>字典管理</span>
          </template>
          <el-menu-item index="1-1">字典管理</el-menu-item>
        </el-sub-menu>

        <!-- 用户管理 -->
        <el-sub-menu index="7">
          <template #title>
            <el-icon>
              <location />
            </el-icon>
            <span>用户管理</span>
          </template>
          <el-menu-item index="1-1">用户管理</el-menu-item>
        </el-sub-menu>

        <!-- 系统管理 -->
        <el-sub-menu index="8">
          <template #title>
            <el-icon>
              <location />
            </el-icon>
            <span>系统管理</span>
          </template>
          <el-menu-item index="1-1">系统管理</el-menu-item>
        </el-sub-menu>

      </el-menu>
    </el-aside>

    <!-- 右侧 -->
    <el-container class="rightContent">
      <!-- 右侧上  -->
      <el-header>
        <el-icon class="show" @click="showMenu"><Fold /></el-icon>
      </el-header>
      <!-- 右侧中 -->
      <el-main>Main</el-main>
      <!-- 右侧下 -->
      <el-footer>@designer diana</el-footer>
    </el-container>
  </el-container>

</template>


<script>
import { defineComponent } from 'vue';
export default defineComponent({
  //定义组件名
  name:"DashboardView",

  data(){
    return{
      //控制左侧菜单左右的展开和折叠，true是折叠，false是展开
      isCollapse : false
    }
  },

  methods : {
    showMenu(){
      this.isCollapse = !this.isCollapse;
    }
  }
})
</script>



<style scoped>
.el-aside {
  background: #000000;
}

.el-header {
  background: #dcfaff5b;
  height: 35px;
  line-height: 35px;
}

.el-footer {
  background: #dcfaff5b;
  height: 35px;
  line-height: 35px;
  text-align: center;
}

.rightContent {
  height: calc(100vh);
}
.menuTitle{
  height: 35px;
  line-height: 35px;
  color: #ffffff;
  text-align: center;
}
.show{
  cursor: pointer;
}
</style>
