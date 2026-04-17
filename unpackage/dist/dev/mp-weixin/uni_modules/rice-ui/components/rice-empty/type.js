"use strict";
const common_vendor = require("../../../../common/vendor.js");
class EmptyProps extends common_vendor.UTS.UTSType {
  static get$UTSMetadata$() {
    return {
      kind: 2,
      get fields() {
        return {
          image: { type: String, optional: true },
          width: { type: "Unknown", optional: true },
          height: { type: "Unknown", optional: true },
          text: { type: String, optional: true },
          textColor: { type: String, optional: true },
          textSize: { type: "Unknown", optional: true },
          marginTop: { type: "Unknown", optional: true },
          customStyle: { type: "Unknown", optional: true }
        };
      },
      name: "EmptyProps"
    };
  }
  constructor(options, metadata = EmptyProps.get$UTSMetadata$(), isJSONParse = false) {
    super();
    this.__props__ = common_vendor.UTS.UTSType.initProps(options, metadata, isJSONParse);
    this.image = this.__props__.image;
    this.width = this.__props__.width;
    this.height = this.__props__.height;
    this.text = this.__props__.text;
    this.textColor = this.__props__.textColor;
    this.textSize = this.__props__.textSize;
    this.marginTop = this.__props__.marginTop;
    this.customStyle = this.__props__.customStyle;
    delete this.__props__;
  }
}
//# sourceMappingURL=../../../../../.sourcemap/mp-weixin/uni_modules/rice-ui/components/rice-empty/type.js.map
