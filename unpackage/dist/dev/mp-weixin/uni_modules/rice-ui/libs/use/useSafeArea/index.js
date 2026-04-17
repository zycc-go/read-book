"use strict";
const common_vendor = require("../../../../../common/vendor.js");
class UseSafeArea extends common_vendor.UTS.UTSType {
  static get$UTSMetadata$() {
    return {
      kind: 2,
      get fields() {
        return {
          safeBottom: { type: "Unknown", optional: false },
          safeTop: { type: "Unknown", optional: false },
          statusBarHeight: { type: "Unknown", optional: false }
        };
      },
      name: "UseSafeArea"
    };
  }
  constructor(options, metadata = UseSafeArea.get$UTSMetadata$(), isJSONParse = false) {
    super();
    this.__props__ = common_vendor.UTS.UTSType.initProps(options, metadata, isJSONParse);
    this.safeBottom = this.__props__.safeBottom;
    this.safeTop = this.__props__.safeTop;
    this.statusBarHeight = this.__props__.statusBarHeight;
    delete this.__props__;
  }
}
function useSafeArea() {
  const safeBottom = common_vendor.ref(0);
  const safeTop = common_vendor.ref(0);
  const statusBarHeight = common_vendor.ref(0);
  const getWindowInfo = () => {
    return common_vendor.__awaiter(this, void 0, void 0, function* () {
      yield common_vendor.nextTick$1();
      const windowInfo = common_vendor.index.getWindowInfo();
      const areaInfo = windowInfo.safeArea;
      if (areaInfo.bottom > 0) {
        safeBottom.value = windowInfo.screenHeight - areaInfo.bottom;
      }
      if (areaInfo.top > 0) {
        safeTop.value = areaInfo.top;
      }
      statusBarHeight.value = windowInfo.statusBarHeight;
    });
  };
  let timer = null;
  common_vendor.onMounted(() => {
    if (timer != null)
      clearTimeout(timer);
    timer = setTimeout(() => {
      getWindowInfo();
    }, 200);
  });
  common_vendor.onUnmounted(() => {
    if (timer != null)
      clearTimeout(timer);
  });
  return new UseSafeArea({
    safeTop,
    safeBottom,
    statusBarHeight
  });
}
exports.useSafeArea = useSafeArea;
//# sourceMappingURL=../../../../../../.sourcemap/mp-weixin/uni_modules/rice-ui/libs/use/useSafeArea/index.js.map
