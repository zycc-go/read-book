@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "SENSELESS_COMPARISON", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uni.UNI4CF4B90
import io.dcloud.uniapp.*
import io.dcloud.uniapp.extapi.*
import io.dcloud.uniapp.framework.*
import io.dcloud.uniapp.runtime.*
import io.dcloud.uniapp.vue.*
import io.dcloud.uniapp.vue.shared.*
import io.dcloud.unicloud.*
import io.dcloud.uts.*
import io.dcloud.uts.Map
import io.dcloud.uts.Set
import io.dcloud.uts.UTSAndroid
import kotlin.properties.Delegates
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo
open class GenPagesBookcaseIndex : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {}
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesBookcaseIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesBookcaseIndex
            val _cache = __ins.renderCache
            val onSearch = fun(){
                uni_navigateTo(NavigateToOptions(url = "/pages/search/index"))
            }
            val onBookClick = fun(book: BookItem){
                uni_navigateTo(NavigateToOptions(url = "/pages/library/index?bookId=" + book.id))
            }
            return fun(): Any? {
                val _component_rice_icon = resolveEasyComponent("rice-icon", GenUniModulesRiceUiComponentsRiceIconRiceIconClass)
                val _component_rice_navbar = resolveEasyComponent("rice-navbar", GenUniModulesRiceUiComponentsRiceNavbarRiceNavbarClass)
                val _component_rice_empty = resolveEasyComponent("rice-empty", GenUniModulesRiceUiComponentsRiceEmptyRiceEmptyClass)
                val _component_rice_image = resolveEasyComponent("rice-image", GenUniModulesRiceUiComponentsRiceImageRiceImageClass)
                return _cE("view", _uM("class" to _nC(_uA(
                    "rice-theme-" + unref(state).appTheme,
                    "page"
                ))), _uA(
                    _cV(_component_rice_navbar, _uM("left-arrow" to false, "height" to unref(state).navbarHeight), _uM("left" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("text", _uM("class" to "read-time"), "今天阅读了30分钟")
                        )
                    }
                    ), "right" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("view", _uM("class" to "nav-right"), _uA(
                                _cV(_component_rice_icon, _uM("name" to "search", "class" to "nav-icon", "onClick" to onSearch))
                            ))
                        )
                    }
                    ), "_" to 1), 8, _uA(
                        "height"
                    )),
                    _cE("scroll-view", _uM("class" to "book-list", "scroll-y" to ""), _uA(
                        if (unref(bookList).length === 0) {
                            _cE("view", _uM("key" to 0, "class" to "empty"), _uA(
                                _cV(_component_rice_empty, _uM("description" to "书架空空如也，快去添加书籍吧"))
                            ))
                        } else {
                            _cE("view", _uM("key" to 1, "class" to "book-grid"), _uA(
                                _cE("view", _uM("class" to "book-list"), _uA(
                                    _cE(Fragment, null, RenderHelpers.renderList(unref(bookList), fun(item, index, __index, _cached): Any {
                                        return _cE("view", _uM("key" to item.id, "class" to _nC(if (index > 0) {
                                            "book-li book-li-top"
                                        } else {
                                            "book-li"
                                        }
                                        ), "onClick" to fun(){
                                            onBookClick(item)
                                        }
                                        ), _uA(
                                            _cE("view", _uM("class" to "book-li-avatar"), _uA(
                                                _cV(_component_rice_image, _uM("width" to "100%", "height" to "100%", "src" to "/static/logo.png", "mode" to "aspectFill", "radius" to "8px"))
                                            )),
                                            _cE("view", _uM("class" to "book-li-content"), _uA(
                                                _cE("text", _uM("class" to "book-title"), _tD(item?.title), 1),
                                                _cE("view", _uM("class" to "book-li-row"), _uA(
                                                    _cE("text", _uM("class" to "book-sub"), _tD(item?.author), 1),
                                                    _cE("text", _uM("class" to "book-sub"), "·" + _tD(item?.lastUpdateTime), 1)
                                                )),
                                                _cE("view", _uM("class" to "book-li-row"), _uA(
                                                    _cE("text", _uM("class" to "book-sub-dot"), "最新"),
                                                    _cE("text", _uM("class" to "book-sub"), " " + _tD(item?.lastChapter), 1)
                                                )),
                                                _cE("view", _uM("class" to "book-li-row"), _uA(
                                                    _cE("text", _uM("class" to "book-sub-dot"), "当前"),
                                                    _cE("text", _uM("class" to "book-sub"), " " + _tD(item?.readChapter), 1)
                                                ))
                                            )),
                                            _cV(_component_rice_icon, _uM("name" to "info", "class" to "book-li-more", "size" to "24"))
                                        ), 10, _uA(
                                            "onClick"
                                        ))
                                    }
                                    ), 128)
                                ))
                            ))
                        }
                    ))
                ), 2)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("page" to _pS(_uM("backgroundColor" to "var(--rice-navbar-background)", "height" to "100%", "width" to "100%")), "read-time" to _pS(_uM("fontSize" to 12, "color" to "var(--rice-text-color)")), "nav-right" to _pS(_uM("display" to "flex", "flexDirection" to "row", "marginRight" to 15)), "nav-icon" to _uM(".nav-right " to _uM("fontSize" to 26, "marginLeft" to 10)), "book-list" to _pS(_uM("paddingTop" to 0, "paddingRight" to 10, "paddingBottom" to 8, "paddingLeft" to 10)), "book-li-top" to _uM(".book-list " to _uM("marginTop" to 15)), "book-li" to _uM(".book-list " to _uM("display" to "flex", "flexDirection" to "row")), "book-li-avatar" to _uM(".book-list .book-li " to _uM("width" to 60, "height" to 80)), "book-li-content" to _uM(".book-list .book-li " to _uM("marginLeft" to 10, "display" to "flex", "flexDirection" to "column", "justifyContent" to "center")), "book-li-row" to _uM(".book-list .book-li .book-li-content " to _uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "height" to 18)), "book-title" to _uM(".book-list .book-li .book-li-content " to _uM("fontSize" to 16, "color" to "var(--rice-text-color)")), "book-sub" to _uM(".book-list .book-li .book-li-content " to _uM("fontSize" to 12, "color" to "var(--rice-text-color)")), "book-sub-dot" to _uM(".book-list .book-li .book-li-content " to _uM("paddingTop" to 2, "paddingRight" to 4, "paddingBottom" to 2, "paddingLeft" to 4, "fontSize" to 8, "lineHeight" to "8px", "backgroundColor" to "#9ACD32", "color" to "var(--rice-text-color)", "borderTopLeftRadius" to 3, "borderTopRightRadius" to 3, "borderBottomRightRadius" to 3, "borderBottomLeftRadius" to 3)), "book-li-more" to _uM(".book-list .book-li " to _uM("position" to "absolute", "right" to 0, "top" to 0)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
