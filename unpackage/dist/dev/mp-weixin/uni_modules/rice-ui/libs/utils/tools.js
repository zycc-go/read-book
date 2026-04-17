"use strict";
const common_vendor = require("../../../../common/vendor.js");
const uni_modules_riceUi_libs_store_useConfigStore = require("../store/useConfigStore.js");
function getRandomStr(length = 10) {
  const characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
  let result = "";
  for (let i = 0; i < length; i++) {
    const randomIndex = Math.floor(Math.random() * characters.length);
    result += characters.charAt(randomIndex);
  }
  return result;
}
const hasStrValue = (str = null) => {
  if (str == null)
    return false;
  if (typeof str != "string") {
    str = str.toString();
  }
  return str.trim().length > 0;
};
function getPxNum(value, totalWidth = 0) {
  if (typeof value == "number") {
    if (uni_modules_riceUi_libs_store_useConfigStore.config.unit != "rpx")
      return value;
    value = value + "rpx";
  }
  if (value.endsWith("rpx")) {
    return common_vendor.index.rpx2px(parseFloat(value));
  }
  if (value.endsWith("%")) {
    return parseFloat(value) * 0.01 * totalWidth;
  }
  return parseFloat(value);
}
const isGradientColor = (color = null) => {
  if (color == null || color == "")
    return false;
  const gradientRegex = /(linear-gradient|radial-gradient|conic-gradient)\(/i;
  return gradientRegex.test(color);
};
const isThemeColor = (type = null) => {
  if (type == null || type == "")
    return false;
  return ["primary", "success", "warning", "error"].includes(type);
};
const isSameValue = (value1 = null, value2 = null) => {
  if (value1 == null || value2 == null)
    return false;
  if (typeof value1 == "object" && typeof value2 == "object") {
    return common_vendor.UTS.JSON.stringify(value1) == common_vendor.UTS.JSON.stringify(value2);
  }
  return value1 === value2;
};
const isPromise = (val = null) => {
  return val && typeof val == "object" && typeof val["then"] == "function" && typeof val["catch"] == "function";
};
let InterceptorOption$1 = class InterceptorOption extends common_vendor.UTS.UTSType {
  static get$UTSMetadata$() {
    return {
      kind: 2,
      get fields() {
        return {
          done: { type: "Unknown", optional: false },
          args: { type: common_vendor.UTS.UTSType.withGenerics(Array, ["Any"]), optional: true },
          canceled: { type: "Unknown", optional: true },
          error: { type: "Unknown", optional: true },
          undone: { type: "Unknown", optional: true },
          complete: { type: "Unknown", optional: true }
        };
      },
      name: "InterceptorOption"
    };
  }
  constructor(options, metadata = InterceptorOption.get$UTSMetadata$(), isJSONParse = false) {
    super();
    this.__props__ = common_vendor.UTS.UTSType.initProps(options, metadata, isJSONParse);
    this.done = this.__props__.done;
    this.args = this.__props__.args;
    this.canceled = this.__props__.canceled;
    this.error = this.__props__.error;
    this.undone = this.__props__.undone;
    this.complete = this.__props__.complete;
    delete this.__props__;
  }
};
function callInterceptor(interceptor, interceptorOption) {
  const done = interceptorOption.done, canceled = interceptorOption.canceled, error = interceptorOption.error, undone = interceptorOption.undone, complete = interceptorOption.complete;
  const returnVal = interceptor();
  if (isPromise(returnVal)) {
    const promiseVal = returnVal;
    promiseVal.then((result) => {
      if (result == true) {
        done();
        if (complete != null)
          complete();
      } else {
        if (canceled != null)
          canceled();
        if (undone != null)
          undone();
        if (complete != null)
          complete();
      }
    }).catch(() => {
      if (error != null)
        error();
      if (undone != null)
        undone();
      if (complete != null)
        complete();
    });
  } else {
    if (returnVal == true) {
      done();
    } else if (canceled != null) {
      canceled();
      if (undone != null)
        undone();
    }
    if (complete != null)
      complete();
  }
}
class InterceptorOption2 extends common_vendor.UTS.UTSType {
  static get$UTSMetadata$() {
    return {
      kind: 2,
      get fields() {
        return {
          done: { type: "Unknown", optional: false },
          args: { type: common_vendor.UTS.UTSType.withGenerics(Array, ["Any"]), optional: true },
          canceled: { type: "Unknown", optional: true },
          error: { type: "Unknown", optional: true },
          undone: { type: "Unknown", optional: true },
          complete: { type: "Unknown", optional: true }
        };
      },
      name: "InterceptorOption"
    };
  }
  constructor(options, metadata = InterceptorOption2.get$UTSMetadata$(), isJSONParse = false) {
    super();
    this.__props__ = common_vendor.UTS.UTSType.initProps(options, metadata, isJSONParse);
    this.done = this.__props__.done;
    this.args = this.__props__.args;
    this.canceled = this.__props__.canceled;
    this.error = this.__props__.error;
    this.undone = this.__props__.undone;
    this.complete = this.__props__.complete;
    delete this.__props__;
  }
}
exports.InterceptorOption = InterceptorOption2;
exports.callInterceptor = callInterceptor;
exports.getPxNum = getPxNum;
exports.getRandomStr = getRandomStr;
exports.hasStrValue = hasStrValue;
exports.isGradientColor = isGradientColor;
exports.isSameValue = isSameValue;
exports.isThemeColor = isThemeColor;
//# sourceMappingURL=../../../../../.sourcemap/mp-weixin/uni_modules/rice-ui/libs/utils/tools.js.map
