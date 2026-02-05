import 'D:/Install/HBuilderX/plugins/uniapp-cli-vite/node_modules/@dcloudio/uni-console/src/runtime/app/index.ts';import App from './App.uvue'

import { createSSRApp } from 'vue'
export function createApp() {
	const app = createSSRApp(App)
	
	return {
		app	
	}
}
export function main(app: IApp) {
    definePageRoutes();
    defineAppConfig();
    (createApp()['app'] as VueApp).mount(app, GenUniApp());
}

export class UniAppConfig extends io.dcloud.uniapp.appframe.AppConfig {
    override name: string = "看小说"
    override appid: string = "__UNI__4CF4B90"
    override versionName: string = "1.0.0"
    override versionCode: string = "100"
    override uniCompilerVersion: string = "4.87"
    
    constructor() { super() }
}

import GenPagesBookcaseIndexClass from './pages/bookcase/index.uvue'
import GenPagesLibraryIndexClass from './pages/library/index.uvue'
import GenPagesDiscussIndexClass from './pages/discuss/index.uvue'
import GenPagesMineIndexClass from './pages/mine/index.uvue'
import GenPagesSearchIndexClass from './pages/search/index.uvue'
import GenUniModulesRiceUiPagesActionSheetActionSheetClass from './uni_modules/rice-ui/pages/action-sheet/action-sheet.uvue'
import GenUniModulesRiceUiPagesDialogDialogClass from './uni_modules/rice-ui/pages/dialog/dialog.uvue'
function definePageRoutes() {
__uniRoutes.push({ path: "pages/bookcase/index", component: GenPagesBookcaseIndexClass, meta: { isQuit: true } as UniPageMeta, style: _uM([["navigationBarTitleText",""]]) } as UniPageRoute)
__uniRoutes.push({ path: "pages/library/index", component: GenPagesLibraryIndexClass, meta: { isQuit: false } as UniPageMeta, style: _uM([["navigationBarTitleText",""]]) } as UniPageRoute)
__uniRoutes.push({ path: "pages/discuss/index", component: GenPagesDiscussIndexClass, meta: { isQuit: false } as UniPageMeta, style: _uM([["navigationBarTitleText",""]]) } as UniPageRoute)
__uniRoutes.push({ path: "pages/mine/index", component: GenPagesMineIndexClass, meta: { isQuit: false } as UniPageMeta, style: _uM([["navigationBarTitleText",""]]) } as UniPageRoute)
__uniRoutes.push({ path: "pages/search/index", component: GenPagesSearchIndexClass, meta: { isQuit: false } as UniPageMeta, style: _uM([["navigationBarTitleText",""]]) } as UniPageRoute)
__uniRoutes.push({ path: "uni_modules/rice-ui/pages/action-sheet/action-sheet", component: GenUniModulesRiceUiPagesActionSheetActionSheetClass, meta: { isQuit: false } as UniPageMeta, style: _uM() } as UniPageRoute)
__uniRoutes.push({ path: "uni_modules/rice-ui/pages/dialog/dialog", component: GenUniModulesRiceUiPagesDialogDialogClass, meta: { isQuit: false } as UniPageMeta, style: _uM() } as UniPageRoute)
}
const __uniTabBar: Map<string, any | null> | null = _uM([["color","@tabBarColor"],["selectedColor","@tabBarSelectedColor"],["borderStyle","@tabBarBorderStyle"],["backgroundColor","@tabBarBackgroundColor"],["list",[_uM([["pagePath","pages/bookcase/index"],["iconPath","@tabBarIconPath1"],["selectedIconPath","@tabBarSelectedIconPath1"],["text","书架"]]),_uM([["pagePath","pages/library/index"],["iconPath","@tabBarIconPath2"],["selectedIconPath","@tabBarSelectedIconPath2"],["text","书库"]]),_uM([["pagePath","pages/discuss/index"],["iconPath","@tabBarIconPath3"],["selectedIconPath","@tabBarSelectedIconPath3"],["text","讨论"]]),_uM([["pagePath","pages/mine/index"],["iconPath","@tabBarIconPath4"],["selectedIconPath","@tabBarSelectedIconPath4"],["text","我的"]])]]])
const __uniLaunchPage: Map<string, any | null> = _uM([["url","pages/bookcase/index"],["style",_uM([["navigationBarTitleText",""]])]])
function defineAppConfig(){
  __uniConfig.entryPagePath = '/pages/bookcase/index'
  __uniConfig.globalStyle = _uM([["backgroundColorContent","@globalStyleBackgroundColor"],["navigationStyle","custom"]])
  __uniConfig.getTabBarConfig = ():Map<string, any> | null =>  _uM([["color","@tabBarColor"],["selectedColor","@tabBarSelectedColor"],["borderStyle","@tabBarBorderStyle"],["backgroundColor","@tabBarBackgroundColor"],["list",[_uM([["pagePath","pages/bookcase/index"],["iconPath","@tabBarIconPath1"],["selectedIconPath","@tabBarSelectedIconPath1"],["text","书架"]]),_uM([["pagePath","pages/library/index"],["iconPath","@tabBarIconPath2"],["selectedIconPath","@tabBarSelectedIconPath2"],["text","书库"]]),_uM([["pagePath","pages/discuss/index"],["iconPath","@tabBarIconPath3"],["selectedIconPath","@tabBarSelectedIconPath3"],["text","讨论"]]),_uM([["pagePath","pages/mine/index"],["iconPath","@tabBarIconPath4"],["selectedIconPath","@tabBarSelectedIconPath4"],["text","我的"]])]]])
  __uniConfig.tabBar = __uniConfig.getTabBarConfig()
  __uniConfig.conditionUrl = ''
  __uniConfig.uniIdRouter = _uM()
  __uniConfig.themeConfig = _uM([["light",_uM([["tabBarColor","#2c2c2c"],["tabBarSelectedColor","#d81e06"],["tabBarBorderStyle","black"],["tabBarBackgroundColor","#f5f5f5"],["tabBarIconPath1","static/image/wap-home-o.png"],["tabBarSelectedIconPath1","static/image/wap-home.png"],["tabBarIconPath2","static/image/browsing-history-o.png"],["tabBarSelectedIconPath2","static/image/browsing-history.png"],["tabBarIconPath3","static/image/comment-o.png"],["tabBarSelectedIconPath3","static/image/comment.png"],["tabBarIconPath4","static/image/manager-o.png"],["tabBarSelectedIconPath4","static/image/manager.png"],["globalStyleBackgroundColor","#f5f5f5"]])],["dark",_uM([["tabBarColor","#e6e6e6"],["tabBarSelectedColor","#d81e06"],["tabBarBorderStyle","white"],["tabBarBackgroundColor","#181818"],["tabBarIconPath1","static/image/wap-home-w.png"],["tabBarSelectedIconPath1","static/image/wap-home.png"],["tabBarIconPath2","static/image/browsing-history-w.png"],["tabBarSelectedIconPath2","static/image/browsing-history.png"],["tabBarIconPath3","static/image/comment-w.png"],["tabBarSelectedIconPath3","static/image/comment.png"],["tabBarIconPath4","static/image/manager-w.png"],["tabBarSelectedIconPath4","static/image/manager.png"],["globalStyleBackgroundColor","#181818"]])]])
  __uniConfig.ready = true
}
