"use strict";
const common_vendor = require("../../common/vendor.js");
if (!Array) {
  const _easycom_rice_radio_1 = common_vendor.resolveComponent("rice-radio");
  const _easycom_rice_radio_group_1 = common_vendor.resolveComponent("rice-radio-group");
  const _easycom_rice_collapse_item_1 = common_vendor.resolveComponent("rice-collapse-item");
  const _easycom_rice_collapse_1 = common_vendor.resolveComponent("rice-collapse");
  const _easycom_rice_popup_1 = common_vendor.resolveComponent("rice-popup");
  (_easycom_rice_radio_1 + _easycom_rice_radio_group_1 + _easycom_rice_collapse_item_1 + _easycom_rice_collapse_1 + _easycom_rice_popup_1)();
}
const _easycom_rice_radio = () => "../../uni_modules/rice-ui/components/rice-radio/rice-radio.js";
const _easycom_rice_radio_group = () => "../../uni_modules/rice-ui/components/rice-radio-group/rice-radio-group.js";
const _easycom_rice_collapse_item = () => "../../uni_modules/rice-ui/components/rice-collapse-item/rice-collapse-item.js";
const _easycom_rice_collapse = () => "../../uni_modules/rice-ui/components/rice-collapse/rice-collapse.js";
const _easycom_rice_popup = () => "../../uni_modules/rice-ui/components/rice-popup/rice-popup.js";
if (!Math) {
  (_easycom_rice_radio + _easycom_rice_radio_group + _easycom_rice_collapse_item + _easycom_rice_collapse + _easycom_rice_popup)();
}
const _sfc_main = /* @__PURE__ */ common_vendor.defineComponent(Object.assign({ name: "menu-popup" }, { __name: "popup-menu", setup(__props, _a) {
  var __expose = _a.expose;
  const showMenu = common_vendor.ref(false);
  const value2 = common_vendor.ref("a");
  common_vendor.reactive(new common_vendor.UTSJSONObject({}));
  const openShowMenu = () => {
    showMenu.value = true;
  };
  __expose({
    openShowMenu
  });
  return (_ctx, _cache) => {
    "raw js";
    const __returned__ = {
      a: common_vendor.p({
        value: "list",
        label: "列表"
      }),
      b: common_vendor.p({
        value: "grid",
        label: "宫格"
      }),
      c: common_vendor.o(($event) => {
        return common_vendor.isRef(value2) ? value2.value = $event : null;
      }, "d0"),
      d: common_vendor.p({
        modelValue: common_vendor.unref(value2)
      }),
      e: common_vendor.p({
        name: "typesetting",
        title: "排版"
      }),
      f: common_vendor.t(213),
      g: common_vendor.p({
        name: "c",
        title: "缓存"
      }),
      h: common_vendor.p({
        accordion: true,
        border: true
      }),
      i: common_vendor.o(($event) => {
        return common_vendor.isRef(showMenu) ? showMenu.value = $event : null;
      }, "b5"),
      j: common_vendor.p({
        position: "right",
        radius: "8px",
        ["close-icon"]: "clear",
        duration: 600,
        closeable: false,
        show: common_vendor.unref(showMenu)
      }),
      k: common_vendor.sei(common_vendor.gei(_ctx, ""), "view"),
      l: `${_ctx.u_s_b_h}px`,
      m: common_vendor.pvhc(_ctx.$scope.data.virtualHostClass)
    };
    return __returned__;
  };
} }));
wx.createComponent(_sfc_main);
//# sourceMappingURL=../../../.sourcemap/mp-weixin/pages/bookcase/popup-menu.js.map
