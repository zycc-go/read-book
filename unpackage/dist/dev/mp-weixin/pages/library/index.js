"use strict";
const common_vendor = require("../../common/vendor.js");
if (!Array) {
  const _easycom_rice_navbar_1 = common_vendor.resolveComponent("rice-navbar");
  _easycom_rice_navbar_1();
}
const _easycom_rice_navbar = () => "../../uni_modules/rice-ui/components/rice-navbar/rice-navbar.js";
if (!Math) {
  _easycom_rice_navbar();
}
const _sfc_main = /* @__PURE__ */ common_vendor.defineComponent({
  __name: "index",
  setup(__props) {
    common_vendor.ref("library");
    return (_ctx, _cache) => {
      "raw js";
      const __returned__ = {
        a: common_vendor.p({
          ["left-arrow"]: false,
          ["bg-color"]: "#f8f8f8"
        }),
        b: common_vendor.sei(common_vendor.gei(_ctx, ""), "view"),
        c: `${_ctx.u_s_b_h}px`,
        d: common_vendor.pvhc(_ctx.$scope.data.virtualHostClass)
      };
      return __returned__;
    };
  }
});
wx.createPage(_sfc_main);
//# sourceMappingURL=../../../.sourcemap/mp-weixin/pages/library/index.js.map
