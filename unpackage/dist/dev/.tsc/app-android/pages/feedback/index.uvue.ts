import _easycom_rice_navbar from '@/uni_modules/rice-ui/components/rice-navbar/rice-navbar.uvue'
import _easycom_rice_textarea from '@/uni_modules/rice-ui/components/rice-textarea/rice-textarea.uvue'
import _easycom_rice_button from '@/uni_modules/rice-ui/components/rice-button/rice-button.uvue'
import { state } from '@/store/index.uts'

	
const __sfc__ = defineComponent({
  __name: 'index',
  setup(__props) {
const __ins = getCurrentInstance()!;
const _ctx = __ins.proxy as InstanceType<typeof __sfc__>;
const _cache = __ins.renderCache;

	const value = ref<string>('')

	const onClickLeft = () => {



		uni.switchTab({ url: '/pages/mine/index' })
	}

	const onSubmit = () => {
		uni.showLoading()
		setTimeout(() => {
			// 这里是提交操作
			uni.hideLoading()
		}, 1000)
	}

return (): any | null => {

const _component_rice_navbar = resolveEasyComponent("rice-navbar",_easycom_rice_navbar)
const _component_rice_textarea = resolveEasyComponent("rice-textarea",_easycom_rice_textarea)
const _component_rice_button = resolveEasyComponent("rice-button",_easycom_rice_button)

  return _cE("view", _uM({
    class: _nC([`rice-theme-${unref(state).appTheme}`, "page"])
  }), [
    _cV(_component_rice_navbar, _uM({
      height: unref(state).navbarHeight,
      title: "反馈",
      onClickLeft: onClickLeft
    }), null, 8 /* PROPS */, ["height"]),
    _cE("view", _uM({ class: "card" }), [
      _cV(_component_rice_textarea, _uM({
        modelValue: unref(value),
        "onUpdate:modelValue": $event => {trySetRefValue(value, $event)},
        placeholder: "请输入内容",
        "show-word-limit": "",
        maxlength: 500
      }), null, 8 /* PROPS */, ["modelValue"]),
      _cE("view", _uM({ class: "btn" }), [
        _cV(_component_rice_button, _uM({
          type: "primary",
          text: "提交",
          onClick: onSubmit
        }))
      ])
    ])
  ], 2 /* CLASS */)
}
}

})
export default __sfc__
const GenPagesFeedbackIndexStyles = [_uM([["page", _pS(_uM([["backgroundColor", "var(--rice-navbar-background)"], ["height", "100%"], ["width", "100%"]]))], ["card", _pS(_uM([["paddingTop", 12], ["paddingRight", 15], ["paddingBottom", 12], ["paddingLeft", 15]]))], ["btn", _uM([[".card ", _uM([["marginTop", 12]])]])]])]
