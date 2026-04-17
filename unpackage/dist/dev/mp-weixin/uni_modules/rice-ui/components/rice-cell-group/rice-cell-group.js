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
  name: "rice-cell-group"
}, { __name: "rice-cell-group", props: {
  title: {},
  border: { type: Boolean, default: false },
  radius: {},
  titleStyle: { default: () => {
    return new common_vendor.UTSJSONObject({});
  } },
  customStyle: { default: () => {
    return new common_vendor.UTSJSONObject({});
  } }
}, setup(__props) {
  const ns = uni_modules_riceUi_libs_use_useNamespace_index.useNamespace("cell-group");
  const props = __props;
  const cellGroupStyle = common_vendor.computed(() => {
    const css = /* @__PURE__ */ new Map();
    if (props.radius != null) {
      css.set("border-radius", uni_modules_riceUi_libs_utils_format.addUnit(props.radius));
    }
    return css;
  });
  const cellGroupClass = common_vendor.computed(() => {
    return [
      ns.b(""),
      ns.theme(),
      ns.is("border", props.border)
    ];
  });
  const cellGroupTitleClass = common_vendor.computed(() => {
    return [
      ns.theme()
    ];
  });
  return (_ctx, _cache) => {
    "raw js";
    const __returned__ = common_vendor.e({
      a: common_vendor.unref(uni_modules_riceUi_libs_utils_tools.hasStrValue)(_ctx.title)
    }, common_vendor.unref(uni_modules_riceUi_libs_utils_tools.hasStrValue)(_ctx.title) ? {
      b: common_vendor.t(_ctx.title),
      c: common_vendor.n(common_vendor.unref(cellGroupTitleClass)),
      d: common_vendor.s(_ctx.titleStyle),
      e: common_vendor.s({
        "--status-bar-height": `${_ctx.u_s_b_h}px`
      })
    } : {}, {
      f: common_vendor.n(common_vendor.unref(cellGroupClass)),
      g: common_vendor.s(common_vendor.unref(cellGroupStyle)),
      h: common_vendor.s(_ctx.customStyle),
      i: common_vendor.s({
        "--status-bar-height": `${_ctx.u_s_b_h}px`
      })
    });
    return __returned__;
  };
} }));
const Component = /* @__PURE__ */ common_vendor._export_sfc(_sfc_main, [["__scopeId", "data-v-8ab5cdfe"]]);
wx.createComponent(Component);
//# sourceMappingURL=../../../../../.sourcemap/mp-weixin/uni_modules/rice-ui/components/rice-cell-group/rice-cell-group.js.map
