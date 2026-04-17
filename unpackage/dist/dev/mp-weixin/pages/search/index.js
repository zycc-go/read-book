"use strict";
const common_vendor = require("../../common/vendor.js");
require("../../uni_modules/rice-ui/libs/store/useConfigStore.js");
require("../../uni_modules/rice-ui/libs/use/useCountDown/index.js");
require("../../uni_modules/rice-ui/libs/use/useNamespace/index.js");
require("../../uni_modules/rice-ui/libs/use/usePopup/index.js");
require("../../uni_modules/rice-ui/libs/use/useRelation/useChildren.js");
require("../../uni_modules/rice-ui/libs/use/useRelation/useParent.js");
require("../../uni_modules/rice-ui/libs/use/useSafeArea/index.js");
require("../../uni_modules/rice-ui/libs/use/useTouch/index.js");
require("../../uni_modules/rice-ui/libs/plugin/coloruts/constant.js");
require("../../uni_modules/rice-ui/libs/plugin/coloruts/type.js");
require("../../uni_modules/rice-ui/libs/plugin/dateuts/type.js");
require("../../uni_modules/rice-ui/libs/plugin/dateuts/locale.js");
require("../../uni_modules/rice-ui/components/rice-action-sheet/type.js");
require("../../uni_modules/rice-ui/components/rice-action-sheet/api.js");
require("../../uni_modules/rice-ui/components/rice-button/type.js");
require("../../uni_modules/rice-ui/components/rice-calendar/type.js");
require("../../uni_modules/rice-ui/components/rice-cascader/type.js");
require("../../uni_modules/rice-ui/components/rice-checkbox/type.js");
require("../../uni_modules/rice-ui/components/rice-checkbox-group/index.js");
require("../../uni_modules/rice-ui/components/rice-code-input/type.js");
require("../../uni_modules/rice-ui/components/rice-datetime-picker/type.js");
require("../../uni_modules/rice-ui/components/rice-dialog/type.js");
require("../../uni_modules/rice-ui/components/rice-dialog/api.js");
require("../../uni_modules/rice-ui/components/rice-icon/type.js");
require("../../uni_modules/rice-ui/components/rice-icon/font.js");
require("../../uni_modules/rice-ui/components/rice-float-fab/type.js");
require("../../uni_modules/rice-ui/components/rice-form/index.js");
require("../../uni_modules/rice-ui/components/rice-progress/type.js");
require("../../uni_modules/rice-ui/components/rice-radio/type.js");
require("../../uni_modules/rice-ui/components/rice-radio-group/index.js");
require("../../uni_modules/rice-ui/components/rice-picker/type.js");
require("../../uni_modules/rice-ui/components/rice-swipe-actions/index.js");
require("../../uni_modules/rice-ui/components/rice-swipe-actions-item/type.js");
require("../../uni_modules/rice-ui/components/rice-tabs/type.js");
require("../../uni_modules/rice-ui/components/rice-uploader/type.js");
const store_index = require("../../store/index.js");
if (!Array) {
  const _easycom_rice_search_1 = common_vendor.resolveComponent("rice-search");
  const _easycom_rice_navbar_1 = common_vendor.resolveComponent("rice-navbar");
  (_easycom_rice_search_1 + _easycom_rice_navbar_1)();
}
const _easycom_rice_search = () => "../../uni_modules/rice-ui/components/rice-search/rice-search.js";
const _easycom_rice_navbar = () => "../../uni_modules/rice-ui/components/rice-navbar/rice-navbar.js";
if (!Math) {
  (_easycom_rice_search + _easycom_rice_navbar)();
}
const _sfc_main = /* @__PURE__ */ common_vendor.defineComponent({
  __name: "index",
  setup(__props) {
    const value = common_vendor.ref("");
    const onClickAction = () => {
    };
    return (_ctx, _cache) => {
      "raw js";
      const __returned__ = {
        a: common_vendor.o(($event) => {
          return common_vendor.isRef(value) ? value.value = $event : null;
        }, "64"),
        b: common_vendor.p({
          placeholder: "请输入搜索关键词",
          modelValue: common_vendor.unref(value),
          class: "data-v-d74b41c2"
        }),
        c: common_vendor.o(onClickAction, "a6"),
        d: common_vendor.o(onClickAction, "87"),
        e: common_vendor.p({
          height: common_vendor.unref(store_index.state).navbarHeight,
          ["title-width"]: "calc(100% - 100px)",
          class: "data-v-d74b41c2"
        }),
        f: common_vendor.sei(common_vendor.gei(_ctx, ""), "view"),
        g: common_vendor.n(`rice-theme-${common_vendor.unref(store_index.state).appTheme}`),
        h: common_vendor.pvhc(_ctx.$scope.data.virtualHostClass),
        i: `${_ctx.u_s_b_h}px`
      };
      return __returned__;
    };
  }
});
const MiniProgramPage = /* @__PURE__ */ common_vendor._export_sfc(_sfc_main, [["__scopeId", "data-v-d74b41c2"]]);
wx.createPage(MiniProgramPage);
//# sourceMappingURL=../../../.sourcemap/mp-weixin/pages/search/index.js.map
