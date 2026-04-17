"use strict";
const common_vendor = require("../common/vendor.js");
require("../uni_modules/rice-ui/libs/store/useConfigStore.js");
require("../uni_modules/rice-ui/libs/use/useCountDown/index.js");
require("../uni_modules/rice-ui/libs/use/useNamespace/index.js");
require("../uni_modules/rice-ui/libs/use/usePopup/index.js");
require("../uni_modules/rice-ui/libs/use/useRelation/useChildren.js");
require("../uni_modules/rice-ui/libs/use/useRelation/useParent.js");
require("../uni_modules/rice-ui/libs/use/useSafeArea/index.js");
require("../uni_modules/rice-ui/libs/use/useTouch/index.js");
require("../uni_modules/rice-ui/libs/plugin/coloruts/constant.js");
require("../uni_modules/rice-ui/libs/plugin/coloruts/type.js");
require("../uni_modules/rice-ui/libs/plugin/dateuts/type.js");
require("../uni_modules/rice-ui/libs/plugin/dateuts/locale.js");
require("../uni_modules/rice-ui/components/rice-action-sheet/type.js");
require("../uni_modules/rice-ui/components/rice-action-sheet/api.js");
require("../uni_modules/rice-ui/components/rice-button/type.js");
require("../uni_modules/rice-ui/components/rice-calendar/type.js");
require("../uni_modules/rice-ui/components/rice-cascader/type.js");
require("../uni_modules/rice-ui/components/rice-checkbox/type.js");
require("../uni_modules/rice-ui/components/rice-checkbox-group/index.js");
require("../uni_modules/rice-ui/components/rice-code-input/type.js");
require("../uni_modules/rice-ui/components/rice-datetime-picker/type.js");
require("../uni_modules/rice-ui/components/rice-dialog/type.js");
require("../uni_modules/rice-ui/components/rice-dialog/api.js");
require("../uni_modules/rice-ui/components/rice-icon/type.js");
require("../uni_modules/rice-ui/components/rice-icon/font.js");
require("../uni_modules/rice-ui/components/rice-float-fab/type.js");
require("../uni_modules/rice-ui/components/rice-form/index.js");
require("../uni_modules/rice-ui/components/rice-progress/type.js");
require("../uni_modules/rice-ui/components/rice-radio/type.js");
require("../uni_modules/rice-ui/components/rice-radio-group/index.js");
require("../uni_modules/rice-ui/components/rice-picker/type.js");
require("../uni_modules/rice-ui/components/rice-swipe-actions/index.js");
require("../uni_modules/rice-ui/components/rice-swipe-actions-item/type.js");
require("../uni_modules/rice-ui/components/rice-tabs/type.js");
require("../uni_modules/rice-ui/components/rice-uploader/type.js");
class UserInfo extends common_vendor.UTS.UTSType {
  static get$UTSMetadata$() {
    return {
      kind: 2,
      get fields() {
        return {
          nickName: { type: String, optional: false },
          avatarUrl: { type: String, optional: true }
        };
      },
      name: "UserInfo"
    };
  }
  constructor(options, metadata = UserInfo.get$UTSMetadata$(), isJSONParse = false) {
    super();
    this.__props__ = common_vendor.UTS.UTSType.initProps(options, metadata, isJSONParse);
    this.nickName = this.__props__.nickName;
    this.avatarUrl = this.__props__.avatarUrl;
    delete this.__props__;
  }
}
class State extends common_vendor.UTS.UTSType {
  static get$UTSMetadata$() {
    return {
      kind: 2,
      get fields() {
        return {
          statusBarHeight: { type: Number, optional: false },
          navbarHeight: { type: Number, optional: false },
          uniPlatform: { type: String, optional: false },
          devicePixelRatio: { type: Number, optional: false },
          active: { type: String, optional: false },
          leftWinActive: { type: String, optional: false },
          agreeToPrivacy: { type: Boolean, optional: true },
          isFollowSystem: { type: Boolean, optional: false },
          appTheme: { type: String, optional: false },
          netless: { type: Boolean, optional: false },
          userInfo: { type: UserInfo, optional: true }
        };
      },
      name: "State"
    };
  }
  constructor(options, metadata = State.get$UTSMetadata$(), isJSONParse = false) {
    super();
    this.__props__ = common_vendor.UTS.UTSType.initProps(options, metadata, isJSONParse);
    this.statusBarHeight = this.__props__.statusBarHeight;
    this.navbarHeight = this.__props__.navbarHeight;
    this.uniPlatform = this.__props__.uniPlatform;
    this.devicePixelRatio = this.__props__.devicePixelRatio;
    this.active = this.__props__.active;
    this.leftWinActive = this.__props__.leftWinActive;
    this.agreeToPrivacy = this.__props__.agreeToPrivacy;
    this.isFollowSystem = this.__props__.isFollowSystem;
    this.appTheme = this.__props__.appTheme;
    this.netless = this.__props__.netless;
    this.userInfo = this.__props__.userInfo;
    delete this.__props__;
  }
}
const state = common_vendor.reactive(new State({
  statusBarHeight: 0,
  navbarHeight: 56,
  uniPlatform: "",
  devicePixelRatio: 1,
  active: "componentPage",
  leftWinActive: "/pages/component/view/view",
  appTheme: "light",
  isFollowSystem: false,
  netless: false,
  userInfo: null,
  bookList: [],
  selectedCategory: "all",
  agreeToPrivacy: null
}));
const setAppTheme = (appTheme) => {
  state.appTheme = appTheme;
  try {
    common_vendor.index.setStorage({ key: "appTheme", data: appTheme });
  } catch (e) {
    common_vendor.index.__f__("error", "at store/index.uts:74", "保存主题失败", e);
  }
};
const checkSystemInfo = () => {
  const appBaseInfo = common_vendor.index.getAppBaseInfo();
  const deviceInfo = common_vendor.index.getDeviceInfo();
  const windowInfo = common_vendor.index.getWindowInfo();
  state.uniPlatform = appBaseInfo.uniPlatform || "app";
  state.statusBarHeight = windowInfo.statusBarHeight;
  if (["web", "mp-weixin"].includes(appBaseInfo.uniPlatform)) {
    state.appTheme = appBaseInfo.hostTheme || "light";
  } else {
    state.appTheme = deviceInfo.osTheme || "light";
  }
};
exports.checkSystemInfo = checkSystemInfo;
exports.setAppTheme = setAppTheme;
exports.state = state;
//# sourceMappingURL=../../.sourcemap/mp-weixin/store/index.js.map
