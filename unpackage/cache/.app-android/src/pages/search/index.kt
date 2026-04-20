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
import io.dcloud.uniapp.extapi.navigateBack as uni_navigateBack
import io.dcloud.uniapp.extapi.showToast as uni_showToast
open class GenPagesSearchIndex : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {}
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesSearchIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesSearchIndex
            val _cache = __ins.renderCache
            val keywords = ref("")
            val searchHistoryLists = ref(_uA<SearchHistoryItem>())
            val onBack = fun(){
                uni_navigateBack(null)
            }
            val onClickAction = fun(){
                uni_showToast(ShowToastOptions(title = "搜索" + keywords.value))
            }
            val onSearchItem = fun(item: SearchHistoryItem){
                keywords.value = item.text
                onClickAction()
            }
            val initData = fun(){
                val list: UTSArray<SearchHistoryItem> = _uA()
                val books = _uA(
                    "三体",
                    "活着",
                    "百年孤独",
                    "红楼梦",
                    "西游记",
                    "斗破苍穹",
                    "盗墓笔记",
                    "解忧杂货店"
                )
                run {
                    var i: Number = 1
                    while(i <= 200){
                        val text = books[i % books.length] as String
                        list.push(SearchHistoryItem(id = "" + i, text = text))
                        i++
                    }
                }
                searchHistoryLists.value = list
            }
            initData()
            return fun(): Any? {
                val _component_rice_icon = resolveEasyComponent("rice-icon", GenUniModulesRiceUiComponentsRiceIconRiceIconClass)
                val _component_rice_search = resolveEasyComponent("rice-search", GenUniModulesRiceUiComponentsRiceSearchRiceSearchClass)
                return _cE("view", _uM("class" to _nC(_uA(
                    "rice-theme-" + unref(state).appTheme,
                    "page"
                )), "style" to _nS(_uM("paddingTop" to ("" + unref(state).statusBarHeight + "px")))), _uA(
                    _cE("view", _uM("class" to "page-navbar", "style" to _nS(_uM("height" to ("" + unref(state).navbarHeight + "px"), "top" to ("" + unref(state).statusBarHeight + "px")))), _uA(
                        _cE("view", _uM("class" to "page-navbar-left", "onClick" to onBack), _uA(
                            _cV(_component_rice_icon, _uM("name" to "arrow-left", "size" to "20", "color" to "rgb(50, 50, 51)"))
                        )),
                        _cV(_component_rice_search, _uM("modelValue" to unref(keywords), "onUpdate:modelValue" to fun(`$event`: String){
                            trySetRefValue(keywords, `$event`)
                        }
                        , "placeholder" to "请输入搜索关键词", "show-action" to "", "onSearch" to onClickAction, "onClickAction" to onClickAction), null, 8, _uA(
                            "modelValue"
                        ))
                    ), 4),
                    _cE("view", _uM("class" to "card", "style" to _nS(_uM("marginTop" to ("" + unref(state).navbarHeight + "px"), "paddingBottom" to ("" + (unref(state).navbarHeight + unref(state).safeAreaInsetsHeight) + "px")))), _uA(
                        _cE("text", _uM("class" to "card-title"), "历史记录"),
                        _cE("scroll-view", _uM("direction" to "vertical", "style" to _nS(_uM("flex" to "1"))), _uA(
                            _cE("view", _uM("class" to "tag-list"), _uA(
                                _cE(Fragment, null, RenderHelpers.renderList(unref(searchHistoryLists), fun(item, __key, __index, _cached): Any {
                                    return _cE("text", _uM("class" to "tag", "onClick" to fun(){
                                        onSearchItem(item)
                                    }
                                    ), _tD(item.text), 9, _uA(
                                        "onClick"
                                    ))
                                }
                                ), 256)
                            ))
                        ), 4)
                    ), 4)
                ), 6)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("page" to _pS(_uM("backgroundColor" to "var(--rice-navbar-background)", "width" to "100%", "height" to "100%", "paddingBottom" to 20)), "page-navbar" to _pS(_uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center", "position" to "fixed", "width" to "100%", "zIndex" to 9, "backgroundColor" to "var(--rice-navbar-background)")), "page-navbar-left" to _uM(".page-navbar " to _uM("paddingTop" to 0, "paddingRight" to 10, "paddingBottom" to 0, "paddingLeft" to 10)), "rice-search" to _uM(".page-navbar " to _uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%")), "card" to _pS(_uM("paddingTop" to 0, "paddingRight" to 15, "paddingBottom" to 0, "paddingLeft" to 15, "zIndex" to 0, "height" to "100%")), "card-title" to _uM(".card " to _uM("marginBottom" to 8, "color" to "var(--rice-text-color)")), "scroll-view-box" to _uM(".card " to _uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%")), "tag-list" to _uM(".card " to _uM("display" to "flex", "flexDirection" to "row", "flexWrap" to "wrap", "marginTop" to 0, "marginRight" to -4, "marginBottom" to 0, "marginLeft" to -4)), "tag" to _uM(".card .tag-list " to _uM("marginTop" to 4, "marginRight" to 4, "marginBottom" to 4, "marginLeft" to 4, "paddingTop" to 4, "paddingRight" to 8, "paddingBottom" to 4, "paddingLeft" to 8, "fontSize" to 14, "borderTopLeftRadius" to 3, "borderTopRightRadius" to 3, "borderBottomRightRadius" to 3, "borderBottomLeftRadius" to 3, "color" to "var(--text-color1)", "backgroundColor" to "var(--text-BgColor1)")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
