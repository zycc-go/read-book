"use strict";
const common_vendor = require("../../../../../common/vendor.js");
require("../../utils/format.js");
const uni_modules_riceUi_libs_utils_tools = require("../../utils/tools.js");
let UsePopup$1 = class UsePopup extends common_vendor.UTS.UTSType {
  static get$UTSMetadata$() {
    return {
      kind: 2,
      get fields() {
        return {
          realShow: { type: "Unknown", optional: false },
          doClose: { type: "Unknown", optional: false }
        };
      },
      name: "UsePopup"
    };
  }
  constructor(options, metadata = UsePopup.get$UTSMetadata$(), isJSONParse = false) {
    super();
    this.__props__ = common_vendor.UTS.UTSType.initProps(options, metadata, isJSONParse);
    this.realShow = this.__props__.realShow;
    this.doClose = this.__props__.doClose;
    delete this.__props__;
  }
};
let UsePopupOptions$1 = class UsePopupOptions extends common_vendor.UTS.UTSType {
  static get$UTSMetadata$() {
    return {
      kind: 2,
      get fields() {
        return {
          show: { type: "Unknown", optional: false },
          position: { type: "Unknown", optional: true },
          duration: { type: "Unknown", optional: true },
          opacity: { type: "Unknown", optional: true },
          zoom: { type: "Unknown", optional: true },
          beforeClose: { type: "Unknown", optional: true }
        };
      },
      name: "UsePopupOptions"
    };
  }
  constructor(options, metadata = UsePopupOptions.get$UTSMetadata$(), isJSONParse = false) {
    super();
    this.__props__ = common_vendor.UTS.UTSType.initProps(options, metadata, isJSONParse);
    this.show = this.__props__.show;
    this.position = this.__props__.position;
    this.duration = this.__props__.duration;
    this.opacity = this.__props__.opacity;
    this.zoom = this.__props__.zoom;
    this.beforeClose = this.__props__.beforeClose;
    delete this.__props__;
  }
};
function usePopup(target, options) {
  const instance = common_vendor.getCurrentInstance();
  const realShow = common_vendor.ref(false);
  const closing = common_vendor.ref(false);
  let openTimer = null;
  let openedTimer = null;
  let closeTimer = null;
  const handleOpenTimer = () => {
    if (openTimer != null)
      clearTimeout(openTimer);
    if (openedTimer != null)
      clearTimeout(openedTimer);
  };
  const handleCloseTimer = () => {
    if (closeTimer != null)
      clearTimeout(closeTimer);
  };
  const open = () => {
    return common_vendor.__awaiter(this, void 0, void 0, function* () {
      var _a, _b, _c, _d;
      const duration = (_b = (_a = options.duration) === null || _a === void 0 ? null : _a.value) !== null && _b !== void 0 ? _b : 300;
      realShow.value = true;
      const position = (_d = (_c = options.position) === null || _c === void 0 ? null : _c.value) !== null && _d !== void 0 ? _d : "bottom";
      yield common_vendor.nextTick$1();
      instance.emit("open");
      handleOpenTimer();
      openTimer = setTimeout(() => {
        var _a2, _b2, _c2, _d2;
        (_a2 = target.value) === null || _a2 === void 0 ? null : _a2.style.setProperty("transition-duration", duration + "ms");
        (_b2 = target.value) === null || _b2 === void 0 ? null : _b2.style.setProperty("opacity", "1");
        if (position != "center") {
          (_c2 = target.value) === null || _c2 === void 0 ? null : _c2.style.setProperty("transform", "translate(0px, 0px)");
        } else {
          (_d2 = target.value) === null || _d2 === void 0 ? null : _d2.style.setProperty("transform", "translate(-50%, -50%) scale(1)");
        }
        openedTimer = setTimeout(() => {
          instance.emit("opened");
        }, duration);
      }, 30);
    });
  };
  const close = () => {
    var _a, _b, _c, _d, _e, _f, _g, _h, _j, _k, _l, _m;
    if (!realShow.value)
      return null;
    const duration = (_b = (_a = options.duration) === null || _a === void 0 ? null : _a.value) !== null && _b !== void 0 ? _b : 300;
    instance.emit("close");
    const position = (_d = (_c = options.position) === null || _c === void 0 ? null : _c.value) !== null && _d !== void 0 ? _d : "bottom";
    const opacity = ((_e = options.opacity) === null || _e === void 0 ? null : _e.value) == true ? "0" : "1";
    (_f = target.value) === null || _f === void 0 ? null : _f.style.setProperty("opacity", opacity);
    if (position == "top") {
      (_g = target.value) === null || _g === void 0 ? null : _g.style.setProperty("transform", "translate(0, -100%)");
    } else if (position == "bottom") {
      (_h = target.value) === null || _h === void 0 ? null : _h.style.setProperty("transform", "translate(0px, 100%)");
    } else if (position == "left") {
      (_j = target.value) === null || _j === void 0 ? null : _j.style.setProperty("transform", "translate(-100%, 0)");
    } else if (position == "right") {
      (_k = target.value) === null || _k === void 0 ? null : _k.style.setProperty("transform", "translate(100%, 0)");
    } else {
      const scale = ((_l = options.zoom) === null || _l === void 0 ? null : _l.value) == true ? 0.6 : 1;
      (_m = target.value) === null || _m === void 0 ? null : _m.style.setProperty("transform", `translate(-50%, -50%) scale(${scale})`);
    }
    handleCloseTimer();
    closeTimer = setTimeout(() => {
      realShow.value = false;
      instance.emit("closed");
    }, duration);
  };
  const doClose = () => {
    var _a;
    if (!options.show.value || closing.value)
      return null;
    closing.value = true;
    const beforeClose = (_a = options.beforeClose) === null || _a === void 0 ? null : _a.value;
    if (typeof beforeClose == "function") {
      uni_modules_riceUi_libs_utils_tools.callInterceptor(beforeClose, new uni_modules_riceUi_libs_utils_tools.InterceptorOption({
        args: null,
        canceled: null,
        error: null,
        undone: null,
        done() {
          options.show.value = false;
        },
        complete() {
          closing.value = false;
        }
      }));
    } else {
      options.show.value = false;
      closing.value = false;
    }
  };
  common_vendor.watch(() => {
    return options.show.value;
  }, (newVal) => {
    if (newVal && !realShow.value) {
      open();
    }
    if (!newVal && realShow.value) {
      close();
    }
  });
  common_vendor.onMounted(() => {
    if (options.show.value) {
      realShow.value = true;
      open();
    }
  });
  common_vendor.onUnmounted(() => {
    handleOpenTimer();
    handleCloseTimer();
  });
  return new UsePopup$1({
    realShow,
    doClose
  });
}
class UsePopup2 extends common_vendor.UTS.UTSType {
  static get$UTSMetadata$() {
    return {
      kind: 2,
      get fields() {
        return {
          realShow: { type: "Unknown", optional: false },
          doClose: { type: "Unknown", optional: false }
        };
      },
      name: "UsePopup"
    };
  }
  constructor(options, metadata = UsePopup2.get$UTSMetadata$(), isJSONParse = false) {
    super();
    this.__props__ = common_vendor.UTS.UTSType.initProps(options, metadata, isJSONParse);
    this.realShow = this.__props__.realShow;
    this.doClose = this.__props__.doClose;
    delete this.__props__;
  }
}
class UsePopupOptions2 extends common_vendor.UTS.UTSType {
  static get$UTSMetadata$() {
    return {
      kind: 2,
      get fields() {
        return {
          show: { type: "Unknown", optional: false },
          position: { type: "Unknown", optional: true },
          duration: { type: "Unknown", optional: true },
          opacity: { type: "Unknown", optional: true },
          zoom: { type: "Unknown", optional: true },
          beforeClose: { type: "Unknown", optional: true }
        };
      },
      name: "UsePopupOptions"
    };
  }
  constructor(options, metadata = UsePopupOptions2.get$UTSMetadata$(), isJSONParse = false) {
    super();
    this.__props__ = common_vendor.UTS.UTSType.initProps(options, metadata, isJSONParse);
    this.show = this.__props__.show;
    this.position = this.__props__.position;
    this.duration = this.__props__.duration;
    this.opacity = this.__props__.opacity;
    this.zoom = this.__props__.zoom;
    this.beforeClose = this.__props__.beforeClose;
    delete this.__props__;
  }
}
exports.UsePopupOptions = UsePopupOptions2;
exports.usePopup = usePopup;
//# sourceMappingURL=../../../../../../.sourcemap/mp-weixin/uni_modules/rice-ui/libs/use/usePopup/index.js.map
