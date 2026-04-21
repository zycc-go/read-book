import _easycom_rice_icon from '@/uni_modules/rice-ui/components/rice-icon/rice-icon.uvue'
import _easycom_rice_navbar from '@/uni_modules/rice-ui/components/rice-navbar/rice-navbar.uvue'
import _easycom_rice_empty from '@/uni_modules/rice-ui/components/rice-empty/rice-empty.uvue'
import _easycom_rice_image from '@/uni_modules/rice-ui/components/rice-image/rice-image.uvue'
import { setTheme, showActionSheet, ActionSheetAction } from "@/uni_modules/rice-ui"
	import { state, setAppTheme } from '@/store/index.uts'
	import { bookList, type BookItem } from '@/data/book'


	
const __sfc__ = defineComponent({
  __name: 'index',
  setup(__props) {
const __ins = getCurrentInstance()!;
const _ctx = __ins.proxy as InstanceType<typeof __sfc__>;
const _cache = __ins.renderCache;

	const onShowMenu = () => {
		uni.showToast({ title: '还没有哦', icon: "none" })
	}

	const onSearch = () => {
		uni.navigateTo({
			url: '/pages/search/index'
		})
	}

	const onBookClick = (book : BookItem) => {
		uni.navigateTo({
			url: `/pages/library/index?bookId=${book.id}`
		})
	}

return (): any | null => {

const _component_rice_icon = resolveEasyComponent("rice-icon",_easycom_rice_icon)
const _component_rice_navbar = resolveEasyComponent("rice-navbar",_easycom_rice_navbar)
const _component_rice_empty = resolveEasyComponent("rice-empty",_easycom_rice_empty)
const _component_rice_image = resolveEasyComponent("rice-image",_easycom_rice_image)

  return _cE("view", _uM({
    class: _nC([`rice-theme-${unref(state).appTheme}`, "page"])
  }), [
    _cV(_component_rice_navbar, _uM({
      "left-arrow": false,
      height: unref(state).navbarHeight
    }), _uM({
      left: withSlotCtx((): any[] => [
        _cE("text", _uM({ class: "read-time" }), "今天阅读了30分钟")
      ]),
      right: withSlotCtx((): any[] => [
        _cE("view", _uM({ class: "nav-right" }), [
          _cV(_component_rice_icon, _uM({
            name: "search",
            size: "20",
            class: "nav-icon",
            onClick: onSearch
          })),
          _cV(_component_rice_icon, _uM({
            name: "bars",
            size: "20",
            class: "nav-icon",
            onClick: onShowMenu
          }))
        ])
      ]),
      _: 1 /* STABLE */
    }), 8 /* PROPS */, ["height"]),
    _cE("scroll-view", _uM({
      style: _nS(_uM({"flex":"1"}))
    }), [
      unref(bookList).length == 0
        ? _cE("view", _uM({
            key: 0,
            class: "empty"
          }), [
            _cV(_component_rice_empty, _uM({ description: "书架空空如也，快去添加书籍吧" }))
          ])
        : _cE("view", _uM({
            key: 1,
            class: "book-grid"
          }), [
            _cE("view", _uM({ class: "book-list" }), [
              _cE(Fragment, null, RenderHelpers.renderList(unref(bookList), (item, index, __index, _cached): any => {
                return _cE("view", _uM({
                  key: item.id,
                  class: _nC(index > 0 ? 'book-li book-li-top' : 'book-li'),
                  onClick: () => {onBookClick(item)}
                }), [
                  _cE("view", _uM({ class: "book-li-avatar" }), [
                    _cV(_component_rice_image, _uM({
                      width: "100%",
                      height: "100%",
                      src: "/static/logo.png",
                      mode: "aspectFill",
                      radius: "8px"
                    }))
                  ]),
                  _cE("view", _uM({ class: "book-li-content" }), [
                    _cE("text", _uM({ class: "book-title" }), _tD(item?.title), 1 /* TEXT */),
                    _cE("view", _uM({ class: "book-li-row" }), [
                      _cE("text", _uM({ class: "book-sub" }), _tD(item?.author), 1 /* TEXT */),
                      _cE("text", _uM({ class: "book-sub" }), "·" + _tD(item?.lastUpdateTime), 1 /* TEXT */)
                    ]),
                    _cE("view", _uM({ class: "book-li-row" }), [
                      _cE("text", _uM({ class: "book-sub-dot" }), "最新"),
                      _cE("text", _uM({ class: "book-sub" }), " " + _tD(item?.lastChapter), 1 /* TEXT */)
                    ]),
                    _cE("view", _uM({ class: "book-li-row" }), [
                      _cE("text", _uM({ class: "book-sub-dot" }), "当前"),
                      _cE("text", _uM({ class: "book-sub" }), " " + _tD(item?.readChapter), 1 /* TEXT */)
                    ])
                  ]),
                  _cV(_component_rice_icon, _uM({
                    name: "double-right",
                    class: "book-li-more",
                    size: "20"
                  }))
                ], 10 /* CLASS, PROPS */, ["onClick"])
              }), 128 /* KEYED_FRAGMENT */)
            ])
          ])
    ], 4 /* STYLE */)
  ], 2 /* CLASS */)
}
}

})
export default __sfc__
const GenPagesBookcaseIndexStyles = [_uM([["page", _pS(_uM([["backgroundColor", "var(--rice-navbar-background)"], ["height", "100%"], ["width", "100%"]]))], ["read-time", _pS(_uM([["fontSize", 14], ["color", "var(--text-color2)"]]))], ["nav-right", _pS(_uM([["display", "flex"], ["flexDirection", "row"], ["marginRight", 16]]))], ["nav-icon", _uM([[".nav-right ", _uM([["marginLeft", 12]])]])], ["book-list", _pS(_uM([["paddingTop", 12], ["paddingRight", 16], ["paddingBottom", 12], ["paddingLeft", 16]]))], ["book-li-top", _uM([[".book-list ", _uM([["marginTop", 16]])]])], ["book-li", _uM([[".book-list ", _uM([["display", "flex"], ["flexDirection", "row"]])]])], ["book-li-avatar", _uM([[".book-list .book-li ", _uM([["width", 60], ["height", 80]])]])], ["book-li-content", _uM([[".book-list .book-li ", _uM([["marginLeft", 12], ["display", "flex"], ["flexDirection", "column"], ["justifyContent", "center"]])]])], ["book-li-row", _uM([[".book-list .book-li .book-li-content ", _uM([["display", "flex"], ["flexDirection", "row"], ["alignItems", "center"], ["height", 18]])]])], ["book-title", _uM([[".book-list .book-li .book-li-content ", _uM([["fontSize", 16], ["color", "var(--text-color1)"]])]])], ["book-sub", _uM([[".book-list .book-li .book-li-content ", _uM([["fontSize", 12], ["color", "var(--text-color2)"]])]])], ["book-sub-dot", _uM([[".book-list .book-li .book-li-content ", _uM([["paddingTop", 2], ["paddingRight", 4], ["paddingBottom", 2], ["paddingLeft", 4], ["fontSize", 8], ["lineHeight", "8px"], ["backgroundColor", "#9ACD32"], ["color", "#ffffff"], ["borderTopLeftRadius", 3], ["borderTopRightRadius", 3], ["borderBottomRightRadius", 3], ["borderBottomLeftRadius", 3]])]])], ["book-li-more", _uM([[".book-list .book-li ", _uM([["position", "absolute"], ["right", 0], ["top", 0]])]])]])]
