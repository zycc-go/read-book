"use strict";
const common_vendor = require("../../../../common/vendor.js");
const uni_modules_riceUi_libs_utils_format = require("../../libs/utils/format.js");
const uni_modules_riceUi_libs_utils_tools = require("../../libs/utils/tools.js");
const uni_modules_riceUi_libs_store_useConfigStore = require("../../libs/store/useConfigStore.js");
require("../../libs/use/useCountDown/index.js");
const uni_modules_riceUi_libs_use_useNamespace_index = require("../../libs/use/useNamespace/index.js");
require("../../libs/use/usePopup/index.js");
require("../../libs/use/useRelation/useChildren.js");
require("../../libs/use/useRelation/useParent.js");
require("../../libs/use/useSafeArea/index.js");
require("../../libs/use/useTouch/index.js");
const uni_modules_riceUi_components_riceCollapse_index = require("../rice-collapse/index.js");
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
  name: "rice-collapse-item"
}, { __name: "rice-collapse-item", props: {
  name: {},
  icon: {},
  title: {},
  value: {},
  contentText: {},
  duration: {},
  border: { type: Boolean, default: true },
  contentBorder: { type: Boolean, default: true },
  arrow: { type: Boolean, default: true },
  clickable: { type: Boolean, default: true },
  disabled: { type: Boolean, default: false },
  readonly: { type: Boolean, default: false },
  titleStyle: {},
  valueStyle: {},
  contentStyle: {},
  customStyle: { default: () => {
    return new common_vendor.UTSJSONObject({});
  } }
}, setup(__props) {
  const ns = uni_modules_riceUi_libs_use_useNamespace_index.useNamespace("collapse-item");
  const collapse = common_vendor.inject(uni_modules_riceUi_components_riceCollapse_index.collapseInjectKey);
  const contentId = uni_modules_riceUi_libs_utils_tools.getRandomStr(10);
  const props = __props;
  const showContentBorder = common_vendor.ref(false);
  const wrapperRef = common_vendor.shallowRef(null);
  const contentHeight = common_vendor.ref(0);
  const itemName = common_vendor.computed(() => {
    var _a;
    return (_a = props.name) !== null && _a !== void 0 ? _a : "rice-" + uni_modules_riceUi_libs_utils_tools.getRandomStr();
  });
  const isActive = common_vendor.computed(() => {
    var _a;
    return (_a = collapse === null || collapse === void 0 ? null : collapse.activeNames.value.includes(itemName.value)) !== null && _a !== void 0 ? _a : false;
  });
  common_vendor.computed(() => {
    var _a;
    return (_a = collapse === null || collapse === void 0 ? null : collapse.activeNames.value) !== null && _a !== void 0 ? _a : [];
  });
  const _duration = common_vendor.computed(() => {
    var _a, _b;
    return (_b = (_a = props.duration) !== null && _a !== void 0 ? _a : collapse === null || collapse === void 0 ? null : collapse.duration.value) !== null && _b !== void 0 ? _b : 250;
  });
  const handleHeaderClick = () => {
    if (props.disabled || props.readonly)
      return null;
    collapse === null || collapse === void 0 ? null : collapse.handleItemClick(itemName.value);
  };
  let timer = null;
  const clearTimer = () => {
    if (timer != null)
      clearTimeout(timer);
  };
  const handleTransitionend = (flag) => {
    var _a;
    if (flag) {
      (_a = wrapperRef.value) === null || _a === void 0 ? null : _a.style.setProperty("height", "auto");
    } else {
      showContentBorder.value = false;
    }
  };
  const onTransitionend = () => {
    handleTransitionend(isActive.value);
  };
  const startAnimate = (newVal) => {
    return common_vendor.__awaiter(this, void 0, void 0, function* () {
      var _a, _b, _c;
      const height = `${contentHeight.value}px`;
      const properValue = (_a = wrapperRef.value) === null || _a === void 0 ? null : _a.style.getPropertyValue("height");
      if (newVal)
        showContentBorder.value = true;
      if (!newVal && properValue == "auto") {
        (_b = wrapperRef.value) === null || _b === void 0 ? null : _b.style.setProperty("height", height);
      }
      if (newVal) {
        (_c = wrapperRef.value) === null || _c === void 0 ? null : _c.style.setProperty("height", height);
      } else {
        timer = setTimeout(() => {
          var _a2;
          (_a2 = wrapperRef.value) === null || _a2 === void 0 ? null : _a2.style.setProperty("height", "0px");
        }, 20);
      }
    });
  };
  const instance = common_vendor.getCurrentInstance();
  common_vendor.watch(isActive, (newVal) => {
    return common_vendor.__awaiter(this, void 0, void 0, function* () {
      yield common_vendor.nextTick$1();
      common_vendor.index.createSelectorQuery().in(instance).select(`#${contentId}`).boundingClientRect().exec((res) => {
        var _a;
        if (res.length == 0)
          return null;
        const nodeInfo = res[0];
        contentHeight.value = (_a = nodeInfo === null || nodeInfo === void 0 ? null : nodeInfo.height) !== null && _a !== void 0 ? _a : 0;
        clearTimer();
        startAnimate(newVal);
      });
    });
  }, {
    immediate: true
  });
  const wrapperStyle = common_vendor.computed(() => {
    const css = /* @__PURE__ */ new Map();
    css.set("transition-duration", `${_duration.value}ms`);
    return css;
  });
  const rightIconColor = common_vendor.computed(() => {
    if (props.disabled) {
      return uni_modules_riceUi_libs_store_useConfigStore.isDark.value ? "#4d4d4d" : "#c8c9cc";
    }
    return "";
  });
  const rightIconStyle = common_vendor.computed(() => {
    return new common_vendor.UTSJSONObject({
      transform: isActive.value ? "rotate(-180deg)" : "rotate(0deg)",
      transition: `transform ${_duration.value}ms`
    });
  });
  const hoverClass = common_vendor.computed(() => {
    if (props.disabled || props.readonly || !props.clickable)
      return "none";
    return "rice-collapse-item--hover";
  });
  const titleTextStyle = common_vendor.computed(() => {
    return uni_modules_riceUi_libs_utils_format.splitCssProperty(props.titleStyle).textCssProperty;
  });
  const titleRectStyle = common_vendor.computed(() => {
    return uni_modules_riceUi_libs_utils_format.splitCssProperty(props.titleStyle).rectCssProperty;
  });
  const valueTextStyle = common_vendor.computed(() => {
    return uni_modules_riceUi_libs_utils_format.splitCssProperty(props.valueStyle).textCssProperty;
  });
  const valueRectStyle = common_vendor.computed(() => {
    return uni_modules_riceUi_libs_utils_format.splitCssProperty(props.valueStyle).rectCssProperty;
  });
  const contentTextStyle = common_vendor.computed(() => {
    return uni_modules_riceUi_libs_utils_format.splitCssProperty(props.contentStyle).textCssProperty;
  });
  const contentRectStyle = common_vendor.computed(() => {
    return uni_modules_riceUi_libs_utils_format.splitCssProperty(props.contentStyle).rectCssProperty;
  });
  common_vendor.onUnmounted(() => {
    clearTimer();
  });
  return (_ctx, _cache) => {
    "raw js";
    const __returned__ = common_vendor.e({
      a: common_vendor.t(_ctx.title),
      b: _ctx.disabled ? 1 : "",
      c: common_vendor.s(common_vendor.unref(titleTextStyle)),
      d: common_vendor.s(common_vendor.unref(titleRectStyle)),
      e: _ctx.$slots["value"] != null || common_vendor.unref(uni_modules_riceUi_libs_utils_tools.hasStrValue)(_ctx.value)
    }, _ctx.$slots["value"] != null || common_vendor.unref(uni_modules_riceUi_libs_utils_tools.hasStrValue)(_ctx.value) ? {
      f: common_vendor.t(_ctx.value),
      g: _ctx.disabled ? 1 : "",
      h: common_vendor.s(common_vendor.unref(valueTextStyle)),
      i: common_vendor.s(common_vendor.unref(valueRectStyle))
    } : {}, {
      j: _ctx.arrow
    }, _ctx.arrow ? {
      k: common_vendor.p({
        name: "arrow-down",
        color: common_vendor.unref(rightIconColor),
        ["custom-style"]: common_vendor.unref(rightIconStyle),
        class: "data-v-ee1d9933"
      })
    } : {}, {
      l: _ctx.border ? 1 : "",
      m: common_vendor.unref(hoverClass),
      n: common_vendor.o(handleHeaderClick, "5a"),
      o: common_vendor.t(_ctx.contentText),
      p: common_vendor.s(common_vendor.unref(contentTextStyle)),
      q: common_vendor.sei(common_vendor.unref(contentId), "view"),
      r: common_vendor.s(common_vendor.unref(contentRectStyle)),
      s: common_vendor.sei("r0-ee1d9933", "view", wrapperRef, {
        "k": "wrapperRef"
      }),
      t: common_vendor.s(common_vendor.unref(wrapperStyle)),
      v: _ctx.contentBorder && common_vendor.unref(showContentBorder) ? 1 : "",
      w: common_vendor.o(onTransitionend, "15"),
      x: common_vendor.sei(common_vendor.gei(_ctx, ""), "view"),
      y: common_vendor.n(common_vendor.unref(ns).b("")),
      z: common_vendor.pvhc(_ctx.$scope.data.virtualHostClass),
      A: common_vendor.s(_ctx.customStyle),
      B: common_vendor.s({
        "--status-bar-height": `${_ctx.u_s_b_h}px`
      })
    });
    return __returned__;
  };
} }));
const Component = /* @__PURE__ */ common_vendor._export_sfc(_sfc_main, [["__scopeId", "data-v-ee1d9933"]]);
wx.createComponent(Component);
//# sourceMappingURL=../../../../../.sourcemap/mp-weixin/uni_modules/rice-ui/components/rice-collapse-item/rice-collapse-item.js.map
