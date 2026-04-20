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
open class GenPagesDiscussIndex : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {}
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesDiscussIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesDiscussIndex
            val _cache = __ins.renderCache
            val title = ref("discuss")
            return fun(): Any? {
                val _component_rice_notice_bar = resolveEasyComponent("rice-notice-bar", GenUniModulesRiceUiComponentsRiceNoticeBarRiceNoticeBarClass)
                return _cE("view", _uM("class" to _nC(_uA(
                    "rice-theme-" + unref(state).appTheme,
                    "page"
                )), "style" to _nS(_uM("paddingTop" to ("" + unref(state).statusBarHeight + "px")))), _uA(
                    _cV(_component_rice_notice_bar, _uM("message" to "无语，秋风和老去的誓言，灰色的日子慢慢过去，骄阳无忌，人如黄花。夕阳西下几时回。", "left-icon" to "volume"))
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
                return _uM("page" to _pS(_uM("backgroundColor" to "var(--rice-navbar-background)", "height" to "100%", "width" to "100%")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
