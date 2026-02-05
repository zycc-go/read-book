@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
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
open class GenPagesSearchIndex : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {}
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesSearchIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesSearchIndex
            val _cache = __ins.renderCache
            val value = ref("")
            return fun(): Any? {
                val _component_rice_search = resolveEasyComponent("rice-search", GenUniModulesRiceUiComponentsRiceSearchRiceSearchClass)
                val _component_rice_navbar = resolveEasyComponent("rice-navbar", GenUniModulesRiceUiComponentsRiceNavbarRiceNavbarClass)
                return _cE("view", _uM("class" to _nC("rice-theme-" + unref(state).appTheme)), _uA(
                    _cV(_component_rice_navbar, _uM("height" to unref(state).statusBarHeight), _uM("title" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("view", _uM("class" to "nav-right"), _uA(
                                _cV(_component_rice_search, _uM("modelValue" to unref(value), "onUpdate:modelValue" to fun(`$event`: String){
                                    trySetRefValue(value, `$event`)
                                }
                                , "placeholder" to "请输入搜索关键词"), null, 8, _uA(
                                    "modelValue"
                                ))
                            ))
                        )
                    }
                    ), "_" to 1), 8, _uA(
                        "height"
                    )),
                    _cE("view", _uM("class" to "card"), " 历史记录 ")
                ), 2)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ), _uA(
                GenApp.styles
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("nav-right" to _pS(_uM("display" to "flex", "flexDirection" to "row", "marginRight" to 15)), "nac-icon" to _uM(".nav-right " to _uM("fontSize" to 26, "marginLeft" to 10)), "header" to _pS(_uM("marginTop" to 12, "marginRight" to 15, "marginBottom" to 12, "marginLeft" to 15, "display" to "flex", "flexDirection" to "row")), "h-right" to _uM(".header " to _uM("marginLeft" to 10, "fontSize" to 12, "display" to "flex", "justifyContent" to "center")), "h-text1" to _uM(".header " to _uM("color" to "var(--rice-text-color)")), "h-text2" to _uM(".header " to _uM("marginTop" to 4, "fontSize" to 14, "color" to "var(--rice-text-color-2)")), "card" to _pS(_uM("paddingTop" to 12, "paddingRight" to 15, "paddingBottom" to 12, "paddingLeft" to 15, "marginTop" to 8)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
