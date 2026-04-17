"use strict";
const common_vendor = require("../../../../common/vendor.js");
require("../../libs/use/useCountDown/index.js");
require("../../libs/store/useConfigStore.js");
const uni_modules_riceUi_libs_use_useNamespace_index = require("../../libs/use/useNamespace/index.js");
require("../../libs/use/usePopup/index.js");
require("../../libs/use/useRelation/useChildren.js");
const uni_modules_riceUi_libs_use_useRelation_useParent = require("../../libs/use/useRelation/useParent.js");
require("../../libs/use/useSafeArea/index.js");
require("../../libs/use/useTouch/index.js");
const uni_modules_riceUi_libs_utils_debug = require("../../libs/utils/debug.js");
const uni_modules_riceUi_libs_utils_format = require("../../libs/utils/format.js");
require("../../libs/utils/tools.js");
const uni_modules_riceUi_components_riceGrid_index = require("../rice-grid/index.js");
require("./type.js");
if (!Array) {
  const _easycom_rice_icon_1 = common_vendor.resolveComponent("rice-icon");
  _easycom_rice_icon_1();
}
const _easycom_rice_icon = () => "../rice-icon/rice-icon.js";
if (!Math) {
  _easycom_rice_icon();
}
const _sfc_main = /* @__PURE__ */ common_vendor.defineComponent(Object.assign({
  name: "rice-grid-item"
}, { __name: "rice-grid-item", props: {
  text: {},
  textColor: {},
  textSize: {},
  icon: {},
  iconColor: {},
  iconSize: {},
  to: {},
  bgColor: {},
  customStyle: { default: () => {
    return new common_vendor.UTSJSONObject({});
  } }
}, emits: ["click"], setup(__props, _a) {
  var __emit = _a.emit;
  const emit = __emit;
  uni_modules_riceUi_libs_use_useRelation_useParent.useParent(uni_modules_riceUi_components_riceGrid_index.gridName).childIndex;
  const ns = uni_modules_riceUi_libs_use_useNamespace_index.useNamespace("grid-item");
  const props = __props;
  const grid = common_vendor.inject(uni_modules_riceUi_components_riceGrid_index.gridInjectKey, null);
  const _iconSize = common_vendor.computed(() => {
    var _a2, _b;
    return (_b = (_a2 = props.iconSize) !== null && _a2 !== void 0 ? _a2 : grid === null || grid === void 0 ? null : grid.iconSize.value) !== null && _b !== void 0 ? _b : "32px";
  });
  const _iconColor = common_vendor.computed(() => {
    var _a2;
    return (_a2 = props.iconColor) !== null && _a2 !== void 0 ? _a2 : grid === null || grid === void 0 ? null : grid.iconColor.value;
  });
  const handleClick = () => {
    if (props.to != null) {
      common_vendor.index.navigateTo({
        url: props.to,
        fail: (err) => {
          uni_modules_riceUi_libs_utils_debug.debugWarn("GridItem", err.errMsg);
        }
      });
    }
    emit("click");
  };
  const hoverClass = common_vendor.computed(() => {
    return (grid === null || grid === void 0 ? null : grid.clickable.value) == true ? "rice-grid-item--hover" : "none";
  });
  const gridItemStyle = common_vendor.computed(() => {
    var _a2;
    const css = /* @__PURE__ */ new Map();
    const columnNum = (_a2 = grid === null || grid === void 0 ? null : grid.columnNum.value) !== null && _a2 !== void 0 ? _a2 : 4;
    const percent = 100 / columnNum + "%";
    css.set("flex-basis", percent);
    return css;
  });
  const textStyle = common_vendor.computed(() => {
    var _a2, _b;
    const css = /* @__PURE__ */ new Map();
    const textSize = (_a2 = props.textSize) !== null && _a2 !== void 0 ? _a2 : grid === null || grid === void 0 ? null : grid.textSize.value;
    const textColor = (_b = props.textColor) !== null && _b !== void 0 ? _b : grid === null || grid === void 0 ? null : grid.textColor.value;
    if (textSize != null)
      css.set("font-size", uni_modules_riceUi_libs_utils_format.addUnit(textSize));
    if (textColor != null)
      css.set("color", textColor);
    return css;
  });
  const instance = common_vendor.getCurrentInstance();
  const gridItemClass = common_vendor.computed(() => {
    const base = [
      ns.b(""),
      ns.is("horizontal", (grid === null || grid === void 0 ? null : grid.vertical.value) != true)
    ];
    if ((grid === null || grid === void 0 ? null : grid.border.value) == true) {
      const children = grid.childrenList.value;
      const index = children.findIndex((v) => {
        return v.proxy == (instance === null || instance === void 0 ? null : instance.proxy);
      });
      if (index != -1) {
        const columnNum = grid.columnNum.value;
        if ((index + 1) % columnNum != 0) {
          base.push(ns.m("border--right"));
        }
      }
      base.push(ns.m("border--bottom"));
    }
    return base;
  });
  if (grid == null) {
    uni_modules_riceUi_libs_utils_debug.debugWarn("GridItem", "<GridItem> must be used with <Grid>");
  }
  return (_ctx, _cache) => {
    "raw js";
    const __returned__ = {
      a: common_vendor.p({
        name: _ctx.icon,
        size: common_vendor.unref(_iconSize),
        color: common_vendor.unref(_iconColor),
        class: "data-v-16bc1954"
      }),
      b: common_vendor.t(_ctx.text),
      c: common_vendor.s(common_vendor.unref(textStyle)),
      d: common_vendor.sei(common_vendor.gei(_ctx, ""), "view"),
      e: common_vendor.n(common_vendor.unref(gridItemClass)),
      f: common_vendor.pvhc(_ctx.$scope.data.virtualHostClass),
      g: common_vendor.s(common_vendor.unref(gridItemStyle)),
      h: common_vendor.s(_ctx.customStyle),
      i: common_vendor.s({
        "--status-bar-height": `${_ctx.u_s_b_h}px`
      }),
      j: common_vendor.unref(hoverClass),
      k: common_vendor.o(handleClick, "48")
    };
    return __returned__;
  };
} }));
const Component = /* @__PURE__ */ common_vendor._export_sfc(_sfc_main, [["__scopeId", "data-v-16bc1954"]]);
wx.createComponent(Component);
//# sourceMappingURL=../../../../../.sourcemap/mp-weixin/uni_modules/rice-ui/components/rice-grid-item/rice-grid-item.js.map
