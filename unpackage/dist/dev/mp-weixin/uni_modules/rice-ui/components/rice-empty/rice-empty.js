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
require("./type.js");
const _sfc_main = /* @__PURE__ */ common_vendor.defineComponent(Object.assign({
  name: "rice-empty"
}, { __name: "rice-empty", props: {
  image: { default: "empty" },
  width: {},
  height: {},
  text: {},
  textColor: {},
  textSize: {},
  marginTop: {},
  customStyle: { default: () => {
    return new common_vendor.UTSJSONObject({});
  } }
}, setup(__props) {
  const ns = uni_modules_riceUi_libs_use_useNamespace_index.useNamespace("empty");
  const props = __props;
  const imageSrc = common_vendor.computed(() => {
    if (props.image == "empty") {
      return "";
    } else if (props.image == "error") {
      return "";
    } else if (props.image == "network") {
      return "";
    } else if (props.image == "search") {
      return "";
    }
    return props.image;
  });
  const emptyStyle = common_vendor.computed(() => {
    const css = /* @__PURE__ */ new Map();
    if (props.marginTop != null)
      css.set("marginTop", uni_modules_riceUi_libs_utils_format.addUnit(props.marginTop));
    return css;
  });
  const imageStyle = common_vendor.computed(() => {
    const css = /* @__PURE__ */ new Map();
    if (props.width != null)
      css.set("width", uni_modules_riceUi_libs_utils_format.addUnit(props.width));
    if (props.height != null)
      css.set("height", uni_modules_riceUi_libs_utils_format.addUnit(props.height));
    return css;
  });
  const textStyle = common_vendor.computed(() => {
    const css = /* @__PURE__ */ new Map();
    if (props.textSize != null)
      css.set("text-size", uni_modules_riceUi_libs_utils_format.addUnit(props.textSize));
    if (props.textColor != null)
      css.set("color", props.textColor);
    return css;
  });
  return (_ctx, _cache) => {
    "raw js";
    const __returned__ = common_vendor.e({
      a: common_vendor.unref(imageSrc),
      b: common_vendor.s(common_vendor.unref(imageStyle)),
      c: common_vendor.unref(uni_modules_riceUi_libs_utils_tools.hasStrValue)(_ctx.text)
    }, common_vendor.unref(uni_modules_riceUi_libs_utils_tools.hasStrValue)(_ctx.text) ? {
      d: common_vendor.t(_ctx.text),
      e: common_vendor.s(common_vendor.unref(textStyle))
    } : {}, {
      f: common_vendor.sei(common_vendor.gei(_ctx, ""), "view"),
      g: common_vendor.n(common_vendor.unref(ns).b("")),
      h: common_vendor.n(common_vendor.unref(ns).theme()),
      i: common_vendor.pvhc(_ctx.$scope.data.virtualHostClass),
      j: common_vendor.s(common_vendor.unref(emptyStyle)),
      k: common_vendor.s(_ctx.customStyle),
      l: common_vendor.s({
        "--status-bar-height": `${_ctx.u_s_b_h}px`
      })
    });
    return __returned__;
  };
} }));
const Component = /* @__PURE__ */ common_vendor._export_sfc(_sfc_main, [["__scopeId", "data-v-9af422d8"]]);
wx.createComponent(Component);
//# sourceMappingURL=../../../../../.sourcemap/mp-weixin/uni_modules/rice-ui/components/rice-empty/rice-empty.js.map
