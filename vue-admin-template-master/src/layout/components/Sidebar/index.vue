<template>
  <div :class="{'has-logo':showLogo}">
    <logo v-if="showLogo" :collapse="isCollapse" />
    <el-scrollbar wrap-class="scrollbar-wrapper">
      <el-menu
        :collapse="false"
        :background-color="variables.menuBg"
        :text-color="variables.menuText"
        :active-text-color="variables.menuActiveText"
        mode="vertical"
      >
        <el-menu-item index="1">Deal 01</el-menu-item>
        <el-submenu index="2">
          <template slot="title">Deal 01</template>
          <el-menu-item index="2-1">Deal 01</el-menu-item>
          <el-menu-item index="2-2">Deal 01</el-menu-item>
          <el-menu-item index="2-3">Deal 01</el-menu-item>
          <el-submenu index="2-4">
            <template slot="title">Deal 01</template>
            <el-menu-item index="2-4-1">Deal 01</el-menu-item>
            <el-menu-item index="2-4-2">Deal 01</el-menu-item>
            <el-menu-item index="2-4-3">Deal 01</el-menu-item>
          </el-submenu>
        </el-submenu>
        <el-menu-item index="3" disabled>Center</el-menu-item>
      </el-menu>
    </el-scrollbar>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import Logo from './Logo'
import SidebarItem from './SidebarItem'
import variables from '@/styles/variables.scss'

export default {
  components: { SidebarItem, Logo },
  computed: {
    ...mapGetters([
      'sidebar'
    ]),
    showLogo() {
      return this.$store.state.settings.sidebarLogo
    },
    variables() {
      return variables
    },
    isCollapse() {
      return !this.sidebar.opened
    }
  }
}
</script>
