"use strict";
const common_vendor = require("../../common/vendor.js");
require("../../uni_modules/rice-ui/libs/store/useConfigStore.js");
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
  const _easycom_rice_navbar_1 = common_vendor.resolveComponent("rice-navbar");
  const _easycom_rice_switch_1 = common_vendor.resolveComponent("rice-switch");
  const _easycom_rice_cell_1 = common_vendor.resolveComponent("rice-cell");
  const _easycom_rice_cell_group_1 = common_vendor.resolveComponent("rice-cell-group");
  (_easycom_rice_navbar_1 + _easycom_rice_switch_1 + _easycom_rice_cell_1 + _easycom_rice_cell_group_1)();
}
const _easycom_rice_navbar = () => "../../uni_modules/rice-ui/components/rice-navbar/rice-navbar.js";
const _easycom_rice_switch = () => "../../uni_modules/rice-ui/components/rice-switch/rice-switch.js";
const _easycom_rice_cell = () => "../../uni_modules/rice-ui/components/rice-cell/rice-cell.js";
const _easycom_rice_cell_group = () => "../../uni_modules/rice-ui/components/rice-cell-group/rice-cell-group.js";
if (!Math) {
  (_easycom_rice_navbar + _easycom_rice_switch + _easycom_rice_cell + _easycom_rice_cell_group)();
}
const _sfc_main = /* @__PURE__ */ common_vendor.defineComponent({
  __name: "index",
  setup(__props) {
    const isDark = common_vendor.ref(false);
    const isFollowSystem = common_vendor.ref(false);
    const onChangeIsDark = (value) => {
      isDark.value = value;
      if (value) {
        isFollowSystem.value = false;
      }
    };
    const onChangeIsFollowSystem = (value) => {
      isFollowSystem.value = value;
      if (value) {
        isDark.value = false;
      }
    };
    const onClickLeft = () => {
      common_vendor.index.switchTab({ url: "/pages/mine/index" });
    };
    return (_ctx, _cache) => {
      "raw js";
      const __returned__ = {
        a: common_vendor.o(onClickLeft, "a2"),
        b: common_vendor.p({
          height: common_vendor.unref(store_index.state).navbarHeight,
          title: "设置",
          class: "data-v-688ba005"
        }),
        c: common_vendor.o(onChangeIsDark, "4c"),
        d: common_vendor.o(($event) => {
          return common_vendor.isRef(isDark) ? isDark.value = $event : null;
        }, "e3"),
        e: common_vendor.p({
          modelValue: common_vendor.unref(isDark),
          class: "data-v-688ba005"
        }),
        f: common_vendor.p({
          title: "深色模式",
          class: "data-v-688ba005"
        }),
        g: common_vendor.o(onChangeIsFollowSystem, "ab"),
        h: common_vendor.o(($event) => {
          return common_vendor.isRef(isFollowSystem) ? isFollowSystem.value = $event : null;
        }, "ac"),
        i: common_vendor.p({
          modelValue: common_vendor.unref(isFollowSystem),
          class: "data-v-688ba005"
        }),
        j: common_vendor.p({
          title: "跟随系统设置",
          label: "开启后，自动跟随系统外观模式设置",
          class: "data-v-688ba005"
        }),
        k: common_vendor.p({
          radius: "8px",
          class: "data-v-688ba005"
        }),
        l: common_vendor.sei(common_vendor.gei(_ctx, ""), "view"),
        m: common_vendor.n(`rice-theme-${common_vendor.unref(store_index.state).appTheme}`),
        n: common_vendor.pvhc(_ctx.$scope.data.virtualHostClass),
        o: `${_ctx.u_s_b_h}px`
      };
      return __returned__;
    };
  }
});
const MiniProgramPage = /* @__PURE__ */ common_vendor._export_sfc(_sfc_main, [["__scopeId", "data-v-688ba005"]]);
wx.createPage(MiniProgramPage);
//# sourceMappingURL=../../../.sourcemap/mp-weixin/pages/setting/index.js.map
