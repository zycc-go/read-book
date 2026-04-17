"use strict";
const common_vendor = require("../../../../common/vendor.js");
const uni_modules_riceUi_libs_utils_format = require("../../libs/utils/format.js");
const uni_modules_riceUi_libs_utils_tools = require("../../libs/utils/tools.js");
require("../../libs/use/useCountDown/index.js");
const uni_modules_riceUi_libs_store_useConfigStore = require("../../libs/store/useConfigStore.js");
const uni_modules_riceUi_libs_use_useNamespace_index = require("../../libs/use/useNamespace/index.js");
require("../../libs/use/usePopup/index.js");
require("../../libs/use/useRelation/useChildren.js");
require("../../libs/use/useRelation/useParent.js");
require("../../libs/use/useSafeArea/index.js");
require("../../libs/use/useTouch/index.js");
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
  name: "rice-navbar"
}, { __name: "rice-navbar", props: {
  title: {},
  titleSize: {},
  titleColor: {},
  titleWidth: {},
  fixed: { type: Boolean, default: true },
  placeholder: { type: Boolean, default: true },
  border: { type: Boolean, default: false },
  leftArrow: { type: Boolean, default: true },
  leftIcon: { default: "arrow-left" },
  leftIconSize: { default: "20px" },
  leftIconColor: {},
  leftText: {},
  leftTextColor: {},
  rightText: {},
  rightTextColor: {},
  zIndex: {},
  bgColor: {},
  safeAreaInsetTop: { type: Boolean, default: true },
  height: { default: "44px" },
  autoBack: { type: Boolean, default: true },
  customStyle: { default: () => {
    return new common_vendor.UTSJSONObject({});
  } }
}, emits: ["clickLeft", "clickRight"], setup(__props, _a) {
  var __emit = _a.emit;
  common_vendor.useCssVars((_ctx = null) => {
    return new common_vendor.UTSJSONObject({
      "2ecd2eaf": common_vendor.unref(mpMenuInfo).top + "px",
      "97aa7a94": common_vendor.unref(mpMenuInfo).right + "px"
    });
  });
  const slot = common_vendor.useSlots();
  const emit = __emit;
  const ns = uni_modules_riceUi_libs_use_useNamespace_index.useNamespace("navbar");
  const props = __props;
  const hasLeft = common_vendor.computed(() => {
    return slot["left"] != null || props.leftArrow || uni_modules_riceUi_libs_utils_tools.hasStrValue(props.leftText);
  });
  const hasRight = common_vendor.computed(() => {
    return slot["right"] != null || uni_modules_riceUi_libs_utils_tools.hasStrValue(props.rightText);
  });
  const statusBarHeight = common_vendor.ref(0);
  const clickLeft = (e) => {
    if (slot["left"] != null)
      return null;
    e.stopPropagation();
    if (props.autoBack)
      common_vendor.index.navigateBack();
    emit("clickLeft");
  };
  const clickRight = (e) => {
    if (slot["right"] != null)
      return null;
    e.stopPropagation();
    emit("clickRight");
  };
  const arrowColor = common_vendor.computed(() => {
    if (uni_modules_riceUi_libs_utils_tools.hasStrValue(props.leftIconColor))
      return props.leftIconColor;
    return !uni_modules_riceUi_libs_store_useConfigStore.isDark.value ? "#323233" : "#f5f5f5";
  });
  const navbarHeight = common_vendor.computed(() => {
    let height = uni_modules_riceUi_libs_utils_tools.getPxNum(props.height);
    if (props.safeAreaInsetTop)
      height += statusBarHeight.value;
    return height + "px";
  });
  const centerStyle = common_vendor.computed(() => {
    const css = /* @__PURE__ */ new Map();
    if (props.titleWidth != null)
      css.set("width", uni_modules_riceUi_libs_utils_format.addUnit(props.titleWidth));
    return css;
  });
  const navbarStyle = common_vendor.computed(() => {
    const css = /* @__PURE__ */ new Map();
    if (uni_modules_riceUi_libs_utils_tools.hasStrValue(props.bgColor))
      css.set("background", props.bgColor);
    if (props.fixed && props.zIndex != null)
      css.set("z-index", props.zIndex);
    css.set("height", uni_modules_riceUi_libs_utils_format.addUnit(props.height));
    return css;
  });
  const leftTextStyle = common_vendor.computed(() => {
    const css = /* @__PURE__ */ new Map();
    if (uni_modules_riceUi_libs_utils_tools.hasStrValue(props.leftTextColor))
      css.set("color", props.leftTextColor);
    return css;
  });
  const rightTextStyle = common_vendor.computed(() => {
    const css = /* @__PURE__ */ new Map();
    if (uni_modules_riceUi_libs_utils_tools.hasStrValue(props.rightTextColor))
      css.set("color", props.rightTextColor);
    return css;
  });
  const titleTextStyle = common_vendor.computed(() => {
    const css = /* @__PURE__ */ new Map();
    if (uni_modules_riceUi_libs_utils_tools.hasStrValue(props.titleColor))
      css.set("color", props.titleColor);
    if (props.titleSize != null)
      css.set("font-size", uni_modules_riceUi_libs_utils_format.addUnit(props.titleSize));
    return css;
  });
  const navbarClass = common_vendor.computed(() => {
    return [
      ns.b(""),
      ns.theme(),
      ns.is("fixed", props.fixed),
      ns.is("safearea-top", props.safeAreaInsetTop),
      ns.is("border", props.border)
    ];
  });
  const mpMenuInfo = common_vendor.ref(new common_vendor.UTSJSONObject({
    top: 25,
    right: 0
  }));
  common_vendor.onMounted(() => {
    const windowInfo = common_vendor.index.getWindowInfo();
    const menuButtonInfo = common_vendor.index.getMenuButtonBoundingClientRect();
    mpMenuInfo.value.top = menuButtonInfo.top - (menuButtonInfo.top - windowInfo.statusBarHeight);
    mpMenuInfo.value.right = menuButtonInfo.width - 30;
    statusBarHeight.value = windowInfo.statusBarHeight;
  });
  return (_ctx, _cache) => {
    "raw js";
    const __returned__ = common_vendor.e({
      a: _ctx.fixed && _ctx.placeholder
    }, _ctx.fixed && _ctx.placeholder ? {
      b: common_vendor.s({
        height: common_vendor.unref(navbarHeight)
      }),
      c: common_vendor.s(_ctx.__cssVars()),
      d: common_vendor.s({
        "--status-bar-height": `${_ctx.u_s_b_h}px`
      })
    } : {}, {
      e: common_vendor.unref(hasLeft)
    }, common_vendor.unref(hasLeft) ? common_vendor.e({
      f: _ctx.leftArrow
    }, _ctx.leftArrow ? {
      g: common_vendor.p({
        name: _ctx.leftIcon,
        size: _ctx.leftIconSize,
        color: common_vendor.unref(arrowColor),
        class: "data-v-abe06922"
      })
    } : {}, {
      h: common_vendor.unref(uni_modules_riceUi_libs_utils_tools.hasStrValue)(_ctx.leftText)
    }, common_vendor.unref(uni_modules_riceUi_libs_utils_tools.hasStrValue)(_ctx.leftText) ? {
      i: common_vendor.t(_ctx.leftText),
      j: common_vendor.s(common_vendor.unref(leftTextStyle))
    } : {}, {
      k: _ctx.safeAreaInsetTop ? 1 : "",
      l: common_vendor.o(clickLeft, "6b")
    }) : {}, {
      m: common_vendor.t(_ctx.title),
      n: common_vendor.s(common_vendor.unref(titleTextStyle)),
      o: common_vendor.unref(hasRight) && _ctx.safeAreaInsetTop ? 1 : "",
      p: common_vendor.s(common_vendor.unref(centerStyle)),
      q: common_vendor.unref(hasRight)
    }, common_vendor.unref(hasRight) ? common_vendor.e({
      r: common_vendor.unref(uni_modules_riceUi_libs_utils_tools.hasStrValue)(_ctx.rightText)
    }, common_vendor.unref(uni_modules_riceUi_libs_utils_tools.hasStrValue)(_ctx.rightText) ? {
      s: common_vendor.t(_ctx.rightText),
      t: common_vendor.s(common_vendor.unref(rightTextStyle))
    } : {}, {
      v: _ctx.safeAreaInsetTop ? 1 : "",
      w: common_vendor.o(clickRight, "4b")
    }) : {}, {
      x: common_vendor.n(common_vendor.unref(navbarClass)),
      y: common_vendor.s(common_vendor.unref(navbarStyle)),
      z: common_vendor.s(_ctx.__cssVars()),
      A: common_vendor.s({
        "--status-bar-height": `${_ctx.u_s_b_h}px`
      })
    });
    return __returned__;
  };
} }));
const Component = /* @__PURE__ */ common_vendor._export_sfc(_sfc_main, [["__scopeId", "data-v-abe06922"]]);
wx.createComponent(Component);
//# sourceMappingURL=../../../../../.sourcemap/mp-weixin/uni_modules/rice-ui/components/rice-navbar/rice-navbar.js.map
