import { state } from '@/store/index.uts'
	import MyNavbar from '@/componnets/MyNavbar.uvue';

	
const __sfc__ = defineComponent({
  __name: 'index',
  setup(__props) {
const __ins = getCurrentInstance()!;
const _ctx = __ins.proxy as InstanceType<typeof __sfc__>;
const _cache = __ins.renderCache;

	const style = computed(() => {
		return {
			paddingTop: state.statusBarHeight + state.navbarHeight + 'px',
			paddingBottom: state.safeAreaInsetsHeight + 'px',
		};
	})

	const content = ref<string>('')

	const onInput = (event : UniInputEvent) => {
		content.value = event.detail.value
	}

	const onSubmit = () => {
		// console.log('value', content.value)
		if (content.value.length <= 0) {
			uni.showToast({ title: '请输入内容', icon: 'error' })
			return
		}
		uni.showLoading()
		setTimeout(() => {
			// 这里是提交操作
			uni.hideLoading()
		}, 1000)
	}

return (): any | null => {

  return _cE("view", _uM({
    class: _nC([`theme-${unref(state).appTheme}`, 'page']),
    style: _nS(unref(style))
  }), [
    _cV(unref(MyNavbar), _uM({
      leftArrow: false,
      title: "书库"
    })),
    _cE("view", _uM({ class: "card" }), " 下面是很多的分类。。。 ")
  ], 6 /* CLASS, STYLE */)
}
}

})
export default __sfc__
const GenPagesLibraryIndexStyles = [_uM([["page", _pS(_uM([["backgroundColor", "var(--navbar-background)"], ["height", "100%"], ["width", "100%"]]))], ["card", _pS(_uM([["paddingTop", 12], ["paddingRight", 16], ["paddingBottom", 12], ["paddingLeft", 16]]))], ["textarea-instance", _uM([[".card ", _uM([["minHeight", 140], ["width", "100%"], ["paddingTop", 12], ["paddingRight", 16], ["paddingBottom", 12], ["paddingLeft", 16], ["borderTopLeftRadius", 8], ["borderTopRightRadius", 8], ["borderBottomRightRadius", 8], ["borderBottomLeftRadius", 8], ["fontSize", 14], ["color", "var(--text-color-1)"], ["lineHeight", "24px"], ["backgroundColor", "var(--background-color-2)"]])]])], ["btn", _uM([[".card ", _uM([["marginTop", 12]])]])]])]
