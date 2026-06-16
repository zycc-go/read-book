@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "SENSELESS_COMPARISON", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uni.UNI194B5B1
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
open class GenPagesLibraryIndex : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {}
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesLibraryIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesLibraryIndex
            val _cache = __ins.renderCache
            val style = computed(fun(): UTSJSONObject {
                return _uO("paddingTop" to (state.statusBarHeight + state.navbarHeight + "px"), "paddingBottom" to (state.safeAreaInsetsHeight + "px"))
            }
            )
            val content = ref<String>("")
            return fun(): Any? {
                return _cE("view", _uM("class" to _nC(_uA(
                    "theme-" + unref(state).appTheme,
                    "page"
                )), "style" to _nS(unref(style))), _uA(
                    _cV(unref(GenComponnetsMyNavbarClass), _uM("leftArrow" to false, "title" to "书库")),
                    _cE("view", _uM("class" to "card"), " 下面是很多的分类。。。 ")
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
                return _uM("page" to _pS(_uM("backgroundColor" to "var(--navbar-background)", "height" to "100%", "width" to "100%")), "card" to _pS(_uM("paddingTop" to 12, "paddingRight" to 16, "paddingBottom" to 12, "paddingLeft" to 16)), "textarea-instance" to _uM(".card " to _uM("minHeight" to 140, "width" to "100%", "paddingTop" to 12, "paddingRight" to 16, "paddingBottom" to 12, "paddingLeft" to 16, "borderTopLeftRadius" to 8, "borderTopRightRadius" to 8, "borderBottomRightRadius" to 8, "borderBottomLeftRadius" to 8, "fontSize" to 14, "color" to "var(--text-color-1)", "lineHeight" to "24px", "backgroundColor" to "var(--background-color-2)")), "btn" to _uM(".card " to _uM("marginTop" to 12)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
