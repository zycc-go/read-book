"use strict";
Object.defineProperty(exports, Symbol.toStringTag, { value: "Module" });
const common_vendor = require("./common/vendor.js");
const store_index = require("./store/index.js");
if (!Math) {
  "./pages/bookcase/index.js";
  "./pages/library/index.js";
  "./pages/discuss/index.js";
  "./pages/mine/index.js";
  "./pages/search/index.js";
  "./pages/setting/index.js";
  "./pages/feedback/index.js";
  "./uni_modules/rice-ui/pages/action-sheet/action-sheet.js";
  "./uni_modules/rice-ui/pages/dialog/dialog.js";
}
const _sfc_main = common_vendor.defineComponent({
  onLaunch() {
    common_vendor.index.__f__("log", "at App.uvue:8", "App Launch");
    store_index.checkSystemInfo();
  },
  onShow() {
    common_vendor.index.__f__("log", "at App.uvue:12", "App Show");
  },
  onHide() {
    common_vendor.index.__f__("log", "at App.uvue:15", "App Hide");
  },
  onExit() {
    common_vendor.index.__f__("log", "at App.uvue:36", "App Exit");
  }
});
function createApp() {
  const app = common_vendor.createSSRApp(_sfc_main);
  return {
    app
  };
}
createApp().app.mount("#app");
exports.createApp = createApp;
//# sourceMappingURL=../.sourcemap/mp-weixin/app.js.map
