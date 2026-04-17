"use strict";
const common_vendor = require("../../common/vendor.js");
const uni_modules_riceUi_libs_store_useConfigStore = require("../../uni_modules/rice-ui/libs/store/useConfigStore.js");
require("../../uni_modules/rice-ui/libs/use/useCountDown/index.js");
require("../../uni_modules/rice-ui/libs/use/useNamespace/index.js");
require("../../uni_modules/rice-ui/libs/use/usePopup/index.js");
require("../../uni_modules/rice-ui/libs/use/useRelation/useChildren.js");
require("../../uni_modules/rice-ui/libs/use/useRelation/useParent.js");
require("../../uni_modules/rice-ui/libs/use/useSafeArea/index.js");
require("../../uni_modules/rice-ui/libs/use/useTouch/index.js");
require("../../uni_modules/rice-ui/libs/plugin/coloruts/constant.js");
require("../../uni_modules/rice-ui/libs/plugin/coloruts/type.js");
require("../../uni_modules/rice-ui/libs/plugin/dateuts/type.js");
require("../../uni_modules/rice-ui/libs/plugin/dateuts/locale.js");
require("../../uni_modules/rice-ui/components/rice-action-sheet/type.js");
require("../../uni_modules/rice-ui/components/rice-action-sheet/api.js");
require("../../uni_modules/rice-ui/components/rice-button/type.js");
require("../../uni_modules/rice-ui/components/rice-calendar/type.js");
require("../../uni_modules/rice-ui/components/rice-cascader/type.js");
require("../../uni_modules/rice-ui/components/rice-checkbox/type.js");
require("../../uni_modules/rice-ui/components/rice-checkbox-group/index.js");
require("../../uni_modules/rice-ui/components/rice-code-input/type.js");
require("../../uni_modules/rice-ui/components/rice-datetime-picker/type.js");
require("../../uni_modules/rice-ui/components/rice-dialog/type.js");
require("../../uni_modules/rice-ui/components/rice-dialog/api.js");
require("../../uni_modules/rice-ui/components/rice-icon/type.js");
require("../../uni_modules/rice-ui/components/rice-icon/font.js");
require("../../uni_modules/rice-ui/components/rice-float-fab/type.js");
require("../../uni_modules/rice-ui/components/rice-form/index.js");
require("../../uni_modules/rice-ui/components/rice-progress/type.js");
require("../../uni_modules/rice-ui/components/rice-radio/type.js");
require("../../uni_modules/rice-ui/components/rice-radio-group/index.js");
require("../../uni_modules/rice-ui/components/rice-picker/type.js");
require("../../uni_modules/rice-ui/components/rice-swipe-actions/index.js");
require("../../uni_modules/rice-ui/components/rice-swipe-actions-item/type.js");
require("../../uni_modules/rice-ui/components/rice-tabs/type.js");
require("../../uni_modules/rice-ui/components/rice-uploader/type.js");
const store_index = require("../../store/index.js");
if (!Array) {
  const _easycom_rice_icon_1 = common_vendor.resolveComponent("rice-icon");
  const _easycom_rice_navbar_1 = common_vendor.resolveComponent("rice-navbar");
  const _easycom_rice_avatar_1 = common_vendor.resolveComponent("rice-avatar");
  const _easycom_rice_cell_1 = common_vendor.resolveComponent("rice-cell");
  const _easycom_rice_cell_group_1 = common_vendor.resolveComponent("rice-cell-group");
  const _easycom_rice_dialog_1 = common_vendor.resolveComponent("rice-dialog");
  (_easycom_rice_icon_1 + _easycom_rice_navbar_1 + _easycom_rice_avatar_1 + _easycom_rice_cell_1 + _easycom_rice_cell_group_1 + _easycom_rice_dialog_1)();
}
const _easycom_rice_icon = () => "../../uni_modules/rice-ui/components/rice-icon/rice-icon.js";
const _easycom_rice_navbar = () => "../../uni_modules/rice-ui/components/rice-navbar/rice-navbar.js";
const _easycom_rice_avatar = () => "../../uni_modules/rice-ui/components/rice-avatar/rice-avatar.js";
const _easycom_rice_cell = () => "../../uni_modules/rice-ui/components/rice-cell/rice-cell.js";
const _easycom_rice_cell_group = () => "../../uni_modules/rice-ui/components/rice-cell-group/rice-cell-group.js";
const _easycom_rice_dialog = () => "../../uni_modules/rice-ui/components/rice-dialog/rice-dialog.js";
if (!Math) {
  (_easycom_rice_icon + _easycom_rice_navbar + _easycom_rice_avatar + _easycom_rice_cell + _easycom_rice_cell_group + _easycom_rice_dialog)();
}
const message = `本应用 / 网站 / 内容仅供学习、交流及个人参考使用，不构成任何形式的投资建议、法律意见、专业指导或商业承诺。
	内容准确性：我们力求内容准确、完整、及时，但不保证所有信息绝对无误，不对因内容疏漏、错误或过时导致的任何损失承担责任。
	使用风险：用户基于本应用 / 内容进行的任何操作、决策或行为，均由用户自行承担风险，我们不承担任何直接、间接、附带或衍生的损失赔偿责任。
	第三方链接：本应用 / 内容可能包含第三方链接，第三方网站的内容、隐私政策及服务由其自行负责，我们不对其合法性、安全性及准确性负责。
	版权与合规：本应用 / 内容所使用的素材、代码、数据等，均尽可能遵循版权规范；若涉及侵权，请联系我们及时处理，我们不承担因用户违规使用素材导致的法律责任。
	变更与终止：我们有权随时更新、修改或终止本应用 / 内容，无需提前通知，且不承担因此产生的任何责任。
	适用范围：本声明适用于所有使用本应用 / 内容的用户，使用即视为已阅读、理解并同意本声明全部条款。
	如需适配特定场景（如小说阅读类、工具类、社区类、付费服务类），告诉我用途，我可以帮你定制更精准的版本。`;
const _sfc_main = /* @__PURE__ */ common_vendor.defineComponent({
  __name: "index",
  setup(__props) {
    const showMoreMessage = common_vendor.ref(false);
    const onAbout = () => {
      showMoreMessage.value = true;
    };
    const onSetTheme = (val) => {
      uni_modules_riceUi_libs_store_useConfigStore.setTheme(val);
      store_index.setAppTheme(val);
      if (common_vendor.index.setAppTheme) {
        common_vendor.index.setAppTheme({
          theme: val,
          success: function() {
            common_vendor.index.__f__("log", "at pages/mine/index.uvue:67", `设置appTheme为 ${val} 成功`);
          },
          fail: function(e) {
            common_vendor.index.__f__("log", "at pages/mine/index.uvue:70", `设置appTheme为 ${val} 失败,原因:`, e.errMsg);
          }
        });
      }
    };
    return (_ctx, _cache) => {
      "raw js";
      const __returned__ = common_vendor.e({
        a: common_vendor.unref(store_index.state).uniPlatform === "app"
      }, common_vendor.unref(store_index.state).uniPlatform === "app" ? common_vendor.e({
        b: common_vendor.unref(store_index.state).appTheme === "dark"
      }, common_vendor.unref(store_index.state).appTheme === "dark" ? {
        c: common_vendor.o(($event) => {
          return onSetTheme("light");
        }, "b2"),
        d: common_vendor.p({
          name: "sun",
          class: "nac-icon data-v-f5dd28a3"
        })
      } : {
        e: common_vendor.o(($event) => {
          return onSetTheme("dark");
        }, "5b"),
        f: common_vendor.p({
          name: "sleep",
          class: "nac-icon data-v-f5dd28a3"
        })
      }) : {}, {
        g: common_vendor.p({
          name: "remind",
          class: "nac-icon data-v-f5dd28a3"
        }),
        h: common_vendor.p({
          ["left-arrow"]: false,
          height: common_vendor.unref(store_index.state).navbarHeight,
          class: "data-v-f5dd28a3"
        }),
        i: common_vendor.p({
          src: "/static/images/avatar-square.png",
          size: "large",
          class: "data-v-f5dd28a3"
        }),
        j: common_vendor.p({
          title: "活动",
          arrow: true,
          class: "data-v-f5dd28a3"
        }),
        k: common_vendor.o(() => {
          return common_vendor.index.navigateTo({
            url: "/pages/setting/index"
          });
        }, "51"),
        l: common_vendor.p({
          title: "设置",
          arrow: true,
          class: "data-v-f5dd28a3"
        }),
        m: common_vendor.o(() => {
          return common_vendor.index.navigateTo({
            url: "/pages/feedback/index"
          });
        }, "ef"),
        n: common_vendor.p({
          title: "反馈",
          arrow: true,
          class: "data-v-f5dd28a3"
        }),
        o: common_vendor.o(onAbout, "06"),
        p: common_vendor.p({
          title: "关于",
          value: "0.0.1",
          arrow: true,
          class: "data-v-f5dd28a3"
        }),
        q: common_vendor.p({
          border: true,
          class: "data-v-f5dd28a3"
        }),
        r: common_vendor.n(`rice-theme-${common_vendor.unref(store_index.state).appTheme}`),
        s: `${_ctx.u_s_b_h}px`,
        t: `${_ctx.u_s_b_h}px`,
        v: common_vendor.o(($event) => {
          return common_vendor.isRef(showMoreMessage) ? showMoreMessage.value = $event : null;
        }, "72"),
        w: common_vendor.p({
          title: "关于",
          ["show-cancel-button"]: false,
          message,
          ["confirm-button-text"]: "知道了",
          ["message-align"]: "left",
          show: common_vendor.unref(showMoreMessage),
          class: "data-v-f5dd28a3",
          style: common_vendor.normalizeStyle({
            "--status-bar-height": `${_ctx.u_s_b_h}px`
          })
        })
      });
      return __returned__;
    };
  }
});
const MiniProgramPage = /* @__PURE__ */ common_vendor._export_sfc(_sfc_main, [["__scopeId", "data-v-f5dd28a3"]]);
wx.createPage(MiniProgramPage);
//# sourceMappingURL=../../../.sourcemap/mp-weixin/pages/mine/index.js.map
