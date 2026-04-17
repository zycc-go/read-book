"use strict";
const common_vendor = require("../../../../common/vendor.js");
const uni_modules_riceUi_libs_use_usePopup_index = require("../../libs/use/usePopup/index.js");
require("../../libs/use/useCountDown/index.js");
require("../../libs/store/useConfigStore.js");
const uni_modules_riceUi_libs_use_useNamespace_index = require("../../libs/use/useNamespace/index.js");
require("../../libs/use/useRelation/useChildren.js");
require("../../libs/use/useRelation/useParent.js");
const uni_modules_riceUi_libs_use_useSafeArea_index = require("../../libs/use/useSafeArea/index.js");
require("../../libs/use/useTouch/index.js");
const uni_modules_riceUi_libs_utils_format = require("../../libs/utils/format.js");
require("../../libs/utils/tools.js");
require("./type.js");
if (!Array) {
  const _easycom_rice_overlay_1 = common_vendor.resolveComponent("rice-overlay");
  const _easycom_rice_icon_1 = common_vendor.resolveComponent("rice-icon");
  (_easycom_rice_overlay_1 + _easycom_rice_icon_1)();
}
const _easycom_rice_overlay = () => "../rice-overlay/rice-overlay.js";
const _easycom_rice_icon = () => "../rice-icon/rice-icon.js";
if (!Math) {
  (_easycom_rice_overlay + _easycom_rice_icon)();
}
const _sfc_main = /* @__PURE__ */ common_vendor.defineComponent(Object.assign({
  name: "rice-popup"
}, { __name: "rice-popup", props: /* @__PURE__ */ common_vendor.mergeModels(new common_vendor.UTSJSONObject({
  duration: { default: 300 },
  position: { default: "bottom" },
  zIndex: { default: 999 },
  opacity: { type: Boolean, default: true },
  zoom: { type: Boolean, default: true },
  overlay: { type: Boolean, default: true },
  overlayBgColor: {},
  closeable: { type: Boolean, default: true },
  closeIcon: { default: "cross" },
  closeIconPosition: { default: "top-right" },
  closeOnClickOverlay: { type: Boolean, default: true },
  radius: {},
  bgColor: {},
  safeAreaInsetTop: { type: Boolean, default: false },
  safeAreaInsetBottom: { type: Boolean, default: true },
  beforeClose: {},
  marginTop: {},
  customStyle: { default: () => {
    return new common_vendor.UTSJSONObject({});
  } }
}), new common_vendor.UTSJSONObject({
  "show": {
    type: Boolean,
    default: false
  },
  "showModifiers": {}
})), emits: /* @__PURE__ */ common_vendor.mergeModels(["open", "close", "opened", "closed", "clickOverlay"], ["update:show"]), setup(__props, _a) {
  var __emit = _a.emit;
  const ns = uni_modules_riceUi_libs_use_useNamespace_index.useNamespace("popup");
  const emit = __emit;
  const props = __props;
  const show = common_vendor.useModel(__props, "show");
  const _b = uni_modules_riceUi_libs_use_useSafeArea_index.useSafeArea(), safeTop = _b.safeTop, safeBottom = _b.safeBottom;
  const popupRef = common_vendor.shallowRef(null);
  const _c = uni_modules_riceUi_libs_use_usePopup_index.usePopup(popupRef, new uni_modules_riceUi_libs_use_usePopup_index.UsePopupOptions({
    show,
    duration: common_vendor.toRef(() => {
      return props.duration;
    }),
    position: common_vendor.toRef(() => {
      return props.position;
    }),
    opacity: common_vendor.toRef(() => {
      return props.opacity;
    }),
    zoom: common_vendor.toRef(() => {
      return props.zoom;
    }),
    beforeClose: common_vendor.toRef(() => {
      return props.beforeClose;
    })
  })), realShow = _c.realShow, doClose = _c.doClose;
  const overlayClick = () => {
    emit("clickOverlay");
    if (!props.closeOnClickOverlay) {
      return null;
    }
    doClose();
  };
  const handleClose = (e) => {
    e.stopPropagation();
    doClose();
  };
  const popupStyle = common_vendor.computed(() => {
    const css = /* @__PURE__ */ new Map();
    css.set("z-index", props.zIndex);
    css.set("transition-duration", props.duration + "ms");
    if (props.bgColor != null)
      css.set("background-color", props.bgColor);
    const position = props.position;
    const radius = props.radius != null ? uni_modules_riceUi_libs_utils_format.addUnit(props.radius) : "0px";
    if (position == "top") {
      css.set("border-bottom-left-radius", radius);
      css.set("border-bottom-right-radius", radius);
      if (props.safeAreaInsetTop)
        css.set("padding-top", safeTop.value + "px");
    } else if (position == "bottom") {
      css.set("border-top-left-radius", radius);
      css.set("border-top-right-radius", radius);
      if (props.safeAreaInsetBottom)
        css.set("padding-bottom", safeBottom.value + "px");
    } else if (position == "left") {
      css.set("border-top-right-radius", radius);
      css.set("border-bottom-right-radius", radius);
      if (props.safeAreaInsetBottom)
        css.set("padding-bottom", safeBottom.value + "px");
      if (props.safeAreaInsetTop)
        css.set("padding-top", safeTop.value + "px");
    } else if (position == "right") {
      css.set("border-top-left-radius", radius);
      css.set("border-bottom-left-radius", radius);
      if (props.safeAreaInsetBottom)
        css.set("padding-bottom", safeBottom.value + "px");
      if (props.safeAreaInsetTop)
        css.set("padding-top", safeTop.value + "px");
    } else {
      css.set("border-radius", radius);
      if (props.marginTop != null)
        css.set("margin-top", uni_modules_riceUi_libs_utils_format.addUnit(props.marginTop));
    }
    return css;
  });
  const popupClass = common_vendor.computed(() => {
    return [
      ns.b(""),
      ns.theme(),
      ns.m(props.position),
      ns.is("opacity", props.opacity),
      ns.is("zoom", props.zoom && props.position == "center")
    ];
  });
  common_vendor.computed(() => {
    return [
      ns.e("close"),
      ns.m(`close--${props.closeIconPosition}`)
    ];
  });
  const closeIconStyle = common_vendor.computed(() => {
    const basic = new common_vendor.UTSJSONObject({
      position: "absolute",
      zIndex: 9
    });
    const gap = "16px";
    const closeIconPosition = props.closeIconPosition;
    if (closeIconPosition == "top-right") {
      basic["top"] = gap;
      basic["right"] = gap;
    } else if (closeIconPosition == "top-left") {
      basic["top"] = gap;
      basic["left"] = gap;
    } else if (closeIconPosition == "bottom-left") {
      basic["bottom"] = gap;
      basic["left"] = gap;
    } else if (closeIconPosition == "bottom-right") {
      basic["bottom"] = gap;
      basic["right"] = gap;
    }
    return basic;
  });
  return (_ctx, _cache) => {
    "raw js";
    const __returned__ = common_vendor.e({
      a: _ctx.overlay
    }, _ctx.overlay ? {
      b: common_vendor.o(overlayClick, "c3"),
      c: `${_ctx.u_s_b_h}px`,
      d: common_vendor.p({
        show: show.value,
        ["bg-color"]: _ctx.overlayBgColor,
        duration: _ctx.duration,
        ["z-index"]: _ctx.zIndex - 1,
        ["close-on-click-overlay"]: false,
        class: "data-v-759854fa",
        style: common_vendor.normalizeStyle({
          "--status-bar-height": `${_ctx.u_s_b_h}px`
        })
      })
    } : {}, {
      e: common_vendor.unref(realShow)
    }, common_vendor.unref(realShow) ? common_vendor.e({
      f: _ctx.closeable
    }, _ctx.closeable ? {
      g: common_vendor.o(handleClose, "ae"),
      h: common_vendor.p({
        name: _ctx.closeIcon,
        ["custom-style"]: common_vendor.unref(closeIconStyle),
        size: "20px",
        class: "data-v-759854fa"
      })
    } : {}, {
      i: common_vendor.sei("r0-759854fa", "view", popupRef, {
        "k": "popupRef"
      }),
      j: common_vendor.n(common_vendor.unref(popupClass)),
      k: common_vendor.s(common_vendor.unref(popupStyle)),
      l: common_vendor.s(_ctx.customStyle),
      m: common_vendor.s({
        "--status-bar-height": `${_ctx.u_s_b_h}px`
      })
    }) : {});
    return __returned__;
  };
} }));
const Component = /* @__PURE__ */ common_vendor._export_sfc(_sfc_main, [["__scopeId", "data-v-759854fa"]]);
wx.createComponent(Component);
//# sourceMappingURL=../../../../../.sourcemap/mp-weixin/uni_modules/rice-ui/components/rice-popup/rice-popup.js.map
