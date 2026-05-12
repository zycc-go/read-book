import { state, setAppTheme } from '@/store/index.uts'

	type NavbarPropsType = { __$originalPosition?: UTSSourceMapPosition<"NavbarPropsType", "componnets/MyNavbar.uvue", 21, 7>;
		title ?: string
		leftArrow ?: Boolean
		height ?: number
	}

	
const __sfc__ = defineComponent({
  __name: 'MyNavbar',
  props: {
    title: { type: String, required: false },
    leftArrow: { type: Boolean, required: false },
    height: { type: Number, required: false }
  },
  setup(__props) {
const __ins = getCurrentInstance()!;
const _ctx = __ins.proxy as InstanceType<typeof __sfc__>;
const _cache = __ins.renderCache;

	const props = __props

	const leftArrow = computed(() => props.leftArrow === true ? true : false)

	const navbarHeight = computed(() => (typeof (props.height) === 'number' ? props.height : state.navbarHeight) + 'px')

	const statusBarHeight = computed(() => state.statusBarHeight + 'px')

return (): any | null => {

  return _cE("view", _uM({ class: "navbar-status" }), [
    _cE("view", _uM({
      style: _nS(_uM({height: unref(statusBarHeight)}))
    }), null, 4 /* STYLE */),
    _cE("view", _uM({
      class: "my-navbar",
      style: _nS(_uM({ height: unref(navbarHeight)}))
    }), [
      _cE("view", _uM({ class: "my-navbar-left" }), [
        renderSlot(_ctx.$slots, "left"),
        isTrue(unref(leftArrow))
          ? _cE("text", _uM({ key: 0 }))
          : _cC("v-if", true)
      ]),
      _cE("view", _uM({ class: "my-navbar-title" }), _tD(props.title), 1 /* TEXT */),
      _cE("view", _uM({ class: "my-navbar-right" }), [
        renderSlot(_ctx.$slots, "right")
      ])
    ], 4 /* STYLE */)
  ])
}
}

})
export default __sfc__
const GenComponnetsMyNavbarStyles = [_uM([["my-navbar", _pS(_uM([["display", "flex"], ["flexDirection", "row"], ["alignItems", "center"], ["justifyContent", "space-between"], ["position", "relative"]]))], ["my-navbar-title", _uM([[".my-navbar ", _uM([["position", "absolute"], ["top", "50%"], ["left", "50%"], ["transform", "translate(-50%, -50%)"]])]])]])]
