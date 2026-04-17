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
const data_book = require("../../data/book.js");
if (!Array) {
  const _easycom_rice_icon_1 = common_vendor.resolveComponent("rice-icon");
  const _easycom_rice_navbar_1 = common_vendor.resolveComponent("rice-navbar");
  const _easycom_rice_empty_1 = common_vendor.resolveComponent("rice-empty");
  const _easycom_rice_grid_item_1 = common_vendor.resolveComponent("rice-grid-item");
  const _easycom_rice_grid_1 = common_vendor.resolveComponent("rice-grid");
  (_easycom_rice_icon_1 + _easycom_rice_navbar_1 + _easycom_rice_empty_1 + _easycom_rice_grid_item_1 + _easycom_rice_grid_1)();
}
const _easycom_rice_icon = () => "../../uni_modules/rice-ui/components/rice-icon/rice-icon.js";
const _easycom_rice_navbar = () => "../../uni_modules/rice-ui/components/rice-navbar/rice-navbar.js";
const _easycom_rice_empty = () => "../../uni_modules/rice-ui/components/rice-empty/rice-empty.js";
const _easycom_rice_grid_item = () => "../../uni_modules/rice-ui/components/rice-grid-item/rice-grid-item.js";
const _easycom_rice_grid = () => "../../uni_modules/rice-ui/components/rice-grid/rice-grid.js";
if (!Math) {
  (_easycom_rice_icon + _easycom_rice_navbar + _easycom_rice_empty + _easycom_rice_grid_item + _easycom_rice_grid + common_vendor.unref(PopupMenu))();
}
const PopupMenu = () => "./popup-menu.js";
const _sfc_main = /* @__PURE__ */ common_vendor.defineComponent({
  __name: "index",
  setup(__props) {
    const popupMenuRef = common_vendor.ref(null);
    const onShowMenu = () => {
      if (popupMenuRef.value) {
        popupMenuRef.value.openShowMenu();
      }
    };
    const onSearch = () => {
      common_vendor.index.navigateTo({
        url: "/pages/search/index"
      });
    };
    const onBookClick = (book = null) => {
      common_vendor.index.navigateTo({
        url: `/pages/library/index?bookId=${book.id}`
      });
    };
    return (_ctx, _cache) => {
      "raw js";
      const __returned__ = common_vendor.e({
        a: common_vendor.o(onSearch, "01"),
        b: common_vendor.p({
          name: "search",
          class: "nav-icon data-v-761118d0"
        }),
        c: common_vendor.o(onShowMenu, "78"),
        d: common_vendor.p({
          name: "bars",
          class: "nav-icon data-v-761118d0"
        }),
        e: common_vendor.p({
          ["left-arrow"]: false,
          height: common_vendor.unref(store_index.state).navbarHeight,
          class: "data-v-761118d0"
        }),
        f: common_vendor.unref(data_book.bookList).length === 0
      }, common_vendor.unref(data_book.bookList).length === 0 ? {
        g: common_vendor.p({
          description: "书架空空如也，快去添加书籍吧",
          class: "data-v-761118d0"
        })
      } : {
        h: common_vendor.f(common_vendor.unref(data_book.bookList), (book, index, i0) => {
          return common_vendor.e({
            a: book.cover,
            b: common_vendor.t(book.title),
            c: common_vendor.t(book.author),
            d: book.hasUnread
          }, book.hasUnread ? {
            e: "761118d0-6-" + i0 + "," + ("761118d0-5-" + i0),
            f: common_vendor.p({
              name: "dot",
              size: "12",
              color: "#d81e06",
              class: "data-v-761118d0"
            })
          } : {}, {
            g: book.lastChapter
          }, book.lastChapter ? {
            h: common_vendor.t(book.lastChapter)
          } : {}, {
            i: index,
            j: common_vendor.o(($event) => {
              return onBookClick(book);
            }, index),
            k: "761118d0-5-" + i0 + ",761118d0-4"
          });
        }),
        i: common_vendor.p({
          class: "data-v-761118d0"
        }),
        j: common_vendor.p({
          class: "data-v-761118d0"
        })
      }, {
        k: common_vendor.n(`rice-theme-${common_vendor.unref(store_index.state).appTheme}`),
        l: `${_ctx.u_s_b_h}px`,
        m: common_vendor.sr(popupMenuRef, "761118d0-7", {
          "k": "popupMenuRef"
        }),
        n: `${_ctx.u_s_b_h}px`,
        o: common_vendor.p({
          class: "r data-v-761118d0",
          style: common_vendor.normalizeStyle({
            "--status-bar-height": `${_ctx.u_s_b_h}px`
          })
        })
      });
      return __returned__;
    };
  }
});
const MiniProgramPage = /* @__PURE__ */ common_vendor._export_sfc(_sfc_main, [["__scopeId", "data-v-761118d0"]]);
wx.createPage(MiniProgramPage);
//# sourceMappingURL=../../../.sourcemap/mp-weixin/pages/bookcase/index.js.map
