"use strict";
const common_vendor = require("../../../../common/vendor.js");
const uni_modules_riceUi_libs_store_useConfigStore = require("../store/useConfigStore.js");
class SplitCssPropertyResult extends common_vendor.UTS.UTSType {
  static get$UTSMetadata$() {
    return {
      kind: 2,
      get fields() {
        return {
          textCssProperty: { type: "Unknown", optional: false },
          rectCssProperty: { type: "Unknown", optional: false }
        };
      },
      name: "SplitCssPropertyResult"
    };
  }
  constructor(options, metadata = SplitCssPropertyResult.get$UTSMetadata$(), isJSONParse = false) {
    super();
    this.__props__ = common_vendor.UTS.UTSType.initProps(options, metadata, isJSONParse);
    this.textCssProperty = this.__props__.textCssProperty;
    this.rectCssProperty = this.__props__.rectCssProperty;
    delete this.__props__;
  }
}
const addUnit = (value) => {
  const isNumeric = typeof value == "number" || /^\d+(\.\d+)?$/.test(value);
  return isNumeric ? `${value}${uni_modules_riceUi_libs_store_useConfigStore.config.unit}` : value.toString();
};
const splitCssProperty = (css = null) => {
  const textCssProperty = new common_vendor.UTSJSONObject({});
  const rectCssProperty = new common_vendor.UTSJSONObject({});
  if (css != null) {
    const textProperties = [
      "color",
      "font-family",
      "fontFamily",
      "font-size",
      "fontSize",
      "font-weight",
      "fontWeight",
      "font-style",
      "fontStyle",
      "text-align",
      "textAlign",
      "text-decoration",
      "textDecoration",
      "line-height",
      "lineHeight",
      "letter-spacing",
      "letterSpacing",
      "text-overflow",
      "textOverflow",
      "white-space",
      "whiteSpace",
      "lines"
    ];
    for (let key in css) {
      if (textProperties.includes(key)) {
        textCssProperty[key] = css[key];
      } else {
        rectCssProperty[key] = css[key];
      }
    }
  }
  return new SplitCssPropertyResult({
    textCssProperty,
    rectCssProperty
  });
};
exports.addUnit = addUnit;
exports.splitCssProperty = splitCssProperty;
//# sourceMappingURL=../../../../../.sourcemap/mp-weixin/uni_modules/rice-ui/libs/utils/format.js.map
