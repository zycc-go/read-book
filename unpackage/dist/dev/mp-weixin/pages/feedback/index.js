"use strict";
const common_vendor = require("../../common/vendor.js");
const store_index = require("../../store/index.js");
if (!Array) {
  const _easycom_rice_navbar_1 = common_vendor.resolveComponent("rice-navbar");
  const _easycom_rice_textarea_1 = common_vendor.resolveComponent("rice-textarea");
  const _easycom_rice_button_1 = common_vendor.resolveComponent("rice-button");
  (_easycom_rice_navbar_1 + _easycom_rice_textarea_1 + _easycom_rice_button_1)();
}
const _easycom_rice_navbar = () => "../../uni_modules/rice-ui/components/rice-navbar/rice-navbar.js";
const _easycom_rice_textarea = () => "../../uni_modules/rice-ui/components/rice-textarea/rice-textarea.js";
const _easycom_rice_button = () => "../../uni_modules/rice-ui/components/rice-button/rice-button.js";
if (!Math) {
  (_easycom_rice_navbar + _easycom_rice_textarea + _easycom_rice_button)();
}
const _sfc_main = /* @__PURE__ */ common_vendor.defineComponent({
  __name: "index",
  setup(__props) {
    const value = common_vendor.ref("");
    const onClickLeft = () => {
      common_vendor.index.switchTab({ url: "/pages/mine/index" });
    };
    const onSubmit = () => {
      common_vendor.index.showLoading();
      setTimeout(() => {
        common_vendor.index.hideLoading();
      }, 1e3);
    };
    return (_ctx, _cache) => {
      "raw js";
      const __returned__ = {
        a: common_vendor.o(onClickLeft, "a2"),
        b: common_vendor.p({
          height: common_vendor.unref(store_index.state).navbarHeight,
          title: "反馈",
          class: "data-v-38c627ff"
        }),
        c: common_vendor.o(($event) => {
          return common_vendor.isRef(value) ? value.value = $event : null;
        }, "d5"),
        d: common_vendor.p({
          placeholder: "请输入内容",
          ["show-word-limit"]: true,
          maxlength: 500,
          modelValue: common_vendor.unref(value),
          class: "data-v-38c627ff"
        }),
        e: common_vendor.o(onSubmit, "a9"),
        f: common_vendor.p({
          type: "primary",
          text: "提交",
          class: "data-v-38c627ff"
        }),
        g: common_vendor.sei(common_vendor.gei(_ctx, ""), "view"),
        h: common_vendor.n(`rice-theme-${common_vendor.unref(store_index.state).appTheme}`),
        i: common_vendor.pvhc(_ctx.$scope.data.virtualHostClass),
        j: `${_ctx.u_s_b_h}px`
      };
      return __returned__;
    };
  }
});
const MiniProgramPage = /* @__PURE__ */ common_vendor._export_sfc(_sfc_main, [["__scopeId", "data-v-38c627ff"]]);
wx.createPage(MiniProgramPage);
//# sourceMappingURL=../../../.sourcemap/mp-weixin/pages/feedback/index.js.map
