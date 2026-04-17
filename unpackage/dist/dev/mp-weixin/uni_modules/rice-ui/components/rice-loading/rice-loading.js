"use strict";
const common_vendor = require("../../../../common/vendor.js");
const uni_modules_riceUi_libs_utils_format = require("../../libs/utils/format.js");
const uni_modules_riceUi_libs_utils_tools = require("../../libs/utils/tools.js");
require("../../libs/use/useCountDown/index.js");
require("../../libs/store/useConfigStore.js");
const uni_modules_riceUi_libs_use_useNamespace_index = require("../../libs/use/useNamespace/index.js");
require("../../libs/use/usePopup/index.js");
require("../../libs/use/useRelation/useChildren.js");
require("../../libs/use/useRelation/useParent.js");
require("../../libs/use/useSafeArea/index.js");
require("../../libs/use/useTouch/index.js");
const uni_modules_riceUi_libs_plugin_coloruts_conversion = require("../../libs/plugin/coloruts/conversion.js");
require("../../libs/plugin/coloruts/constant.js");
require("../../libs/plugin/coloruts/type.js");
require("../../libs/plugin/dateuts/type.js");
require("../../libs/plugin/dateuts/locale.js");
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
  name: "rice-loading"
}, { __name: "rice-loading", props: {
  mode: { default: "circular" },
  duration: { default: 1100 },
  color: { default: "#1989fa" },
  inactiveColor: {},
  size: { default: "24px" },
  text: {},
  textColor: {},
  textSize: {},
  vertical: { type: Boolean, default: false },
  timingFunction: { default: "ease-in-out" },
  customStyle: { default: () => {
    return new common_vendor.UTSJSONObject({});
  } }
}, setup(__props) {
  common_vendor.useCssVars((_ctx = null) => {
    return new common_vendor.UTSJSONObject({
      "31e842e0": common_vendor.unref(color),
      "7ace60c0": common_vendor.unref(_duration)
    });
  });
  const slot = common_vendor.useSlots();
  const ns = uni_modules_riceUi_libs_use_useNamespace_index.useNamespace("loading");
  const props = __props;
  const hasText = common_vendor.computed(() => {
    return uni_modules_riceUi_libs_utils_tools.hasStrValue(props.text) || slot["default"] != null;
  });
  const color = common_vendor.computed(() => {
    return uni_modules_riceUi_libs_utils_tools.hasStrValue(props.color) ? props.color : "#1989fa";
  });
  const _duration = common_vendor.computed(() => {
    return props.duration + "ms";
  });
  const circularStyle = common_vendor.computed(() => {
    const css = /* @__PURE__ */ new Map();
    const size = uni_modules_riceUi_libs_utils_format.addUnit(props.size);
    css.set("height", size);
    css.set("width", size);
    return css;
  });
  const semicircleStyle = common_vendor.computed(() => {
    const css = /* @__PURE__ */ new Map();
    const size = uni_modules_riceUi_libs_utils_format.addUnit(props.size);
    css.set("height", size);
    css.set("width", size);
    const hasColor = uni_modules_riceUi_libs_utils_tools.hasStrValue(props.color);
    if (props.mode == "circle") {
      if (uni_modules_riceUi_libs_utils_tools.hasStrValue(props.inactiveColor)) {
        css.set("border-color", props.inactiveColor);
      } else if (hasColor && props.color != "inherit") {
        const rgb = new uni_modules_riceUi_libs_plugin_coloruts_conversion.Coloruts(props.color).toRgb();
        css.set("border-color", `rgba(${rgb["r"]},${rgb["g"]},${rgb["b"]},.2)`);
      }
    }
    css.set("border-top-color", color.value);
    css.set("animation-timing-function", props.timingFunction);
    return css;
  });
  const textStyle = common_vendor.computed(() => {
    const css = /* @__PURE__ */ new Map();
    if (props.vertical) {
      css.set("margin-top", "8px");
    } else {
      css.set("margin-left", "8px");
    }
    if (uni_modules_riceUi_libs_utils_tools.hasStrValue(props.textColor)) {
      css.set("color", props.textColor);
    }
    if (uni_modules_riceUi_libs_utils_tools.hasStrValue(props.textSize)) {
      css.set("font-size", uni_modules_riceUi_libs_utils_format.addUnit(props.textSize));
    }
    return css;
  });
  const loadingClass = common_vendor.computed(() => {
    return [
      ns.b(""),
      ns.theme(),
      ns.is("vertical", props.vertical),
      ns.is("slot", slot["icon"] != null)
    ];
  });
  return (_ctx, _cache) => {
    "raw js";
    const __returned__ = common_vendor.e({
      a: _ctx.mode == "snow" || common_vendor.unref(slot)["icon"] != null
    }, _ctx.mode == "snow" || common_vendor.unref(slot)["icon"] != null ? {
      b: common_vendor.p({
        name: "loading",
        size: _ctx.size,
        color: common_vendor.unref(color),
        type: "primary",
        class: "data-v-55e28e25"
      }),
      c: common_vendor.sei("r0-55e28e25", "view", "coreRef"),
      d: common_vendor.n(common_vendor.unref(ns).m("snow"))
    } : _ctx.mode == "semicircle" || _ctx.mode == "circle" ? {
      f: common_vendor.sei("r1-55e28e25", "view", "coreRef"),
      g: common_vendor.n(common_vendor.unref(ns).m(_ctx.mode)),
      h: common_vendor.s(common_vendor.unref(semicircleStyle))
    } : {
      i: common_vendor.sei("r2-55e28e25", "view", "circularRef"),
      j: common_vendor.n(common_vendor.unref(ns).m("circular")),
      k: common_vendor.s(common_vendor.unref(circularStyle))
    }, {
      e: _ctx.mode == "semicircle" || _ctx.mode == "circle",
      l: common_vendor.unref(hasText)
    }, common_vendor.unref(hasText) ? {
      m: common_vendor.t(_ctx.text),
      n: common_vendor.n(common_vendor.unref(ns).e("text")),
      o: common_vendor.s(common_vendor.unref(textStyle))
    } : {}, {
      p: common_vendor.sei(common_vendor.gei(_ctx, "", "r3-55e28e25"), "view", "loadingRef"),
      q: common_vendor.n(common_vendor.unref(loadingClass)),
      r: common_vendor.pvhc(_ctx.$scope.data.virtualHostClass),
      s: common_vendor.s(_ctx.customStyle),
      t: common_vendor.s(_ctx.__cssVars()),
      v: common_vendor.s({
        "--status-bar-height": `${_ctx.u_s_b_h}px`
      })
    });
    return __returned__;
  };
} }));
const Component = /* @__PURE__ */ common_vendor._export_sfc(_sfc_main, [["__scopeId", "data-v-55e28e25"]]);
wx.createComponent(Component);
//# sourceMappingURL=../../../../../.sourcemap/mp-weixin/uni_modules/rice-ui/components/rice-loading/rice-loading.js.map
