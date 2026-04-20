import _easycom_rice_icon from '@/uni_modules/rice-ui/components/rice-icon/rice-icon.uvue'
import { useNamespace } from '../../libs/use';
	import { addUnit, hasStrValue, getRandomStr, isThemeColor } from "../../libs/utils";
	import { NoticeBarProps, NoticeBarState } from './type.uts';

	
const __sfc__ = defineComponent({
  __name: 'rice-notice-bar',

		name: 'rice-notice-bar'
	,
  props: {
    type: { type: String, required: false, default: 'warning' },
    message: { type: String, required: false },
    color: { type: String, required: false },
    fontSize: { type: [String, Number], required: false },
    bgColor: { type: String, required: false },
    leftIcon: { type: String, required: false },
    rightIcon: { type: String, required: false },
    delay: { type: Number, required: false },
    speed: { type: Number, required: false, default: 60 },
    closeable: { type: Boolean, required: false, default: false },
    scrollable: { type: Boolean, required: false, default: null },
    wrapable: { type: Boolean, required: false },
    customStyle: { type: UTSJSONObject, required: false, default: () : UTSJSONObject => ({}) }
  },
  emits: ["click", "clickLeft", "clickRight"],
  setup(__props, __setupCtx: SetupContext) {
const __expose = __setupCtx.expose
const __ins = getCurrentInstance()!;
const _ctx = __ins.proxy as InstanceType<typeof __sfc__>;
const _cache = __ins.renderCache;

	/**
	 * @description NoriceBar
	 * @property {String} type 通知类型
	 * @value primary 主要
	 * @value warning 警告（默认值）
	 * @value success 成功
	 * @value error 错误
	 * @property {String} message 通知文本内容
	 * @property {String} color 通知文本颜色
	 * @property {String} fontSize 通知文本大小
	 * @property {String} bgColor 背景颜色
	 * @property {String} leftIcon 左侧图标名称
	 * @property {String} rightIcon 右侧图标名称
	 * @property {Number} delay 动画延迟时间，单位s
	 * @property {Number} speed 滚动速度，单位ms
	 * @property {Boolean} closeable 是否可关闭
	 * @property {Boolean} scrollable 是否开启滚动播放，内容长度溢出时默认开启，wrapable为 true 时恒关闭
	 * @property {Boolean} wrapable 是否开启文本换行，开启文本换行后，内容恒不会滚动
	 * @property {Object} customStyle 自定义样式
	 */
	
	const ns = useNamespace('notice-bar')

	function emit(event: string, ...do_not_transform_spread: Array<any | null>) {
__ins.emit(event, ...do_not_transform_spread)
}

	const props = __props

	const state = reactive<NoticeBarState>({
		show: true,
		offset: 0,
		duration: 0,
		wrapWidth: 0,
		contentWidth: 0,
	})

	let startTimer : number | null = null
	let endTimer : number | null = null
	let transitionTimer : number | null = null
	const wrapperRef = shallowRef<UniElement | null>(null)
	const contentRef = shallowRef<UniElement | null>(null)

	const startSleep = () => {
		return new Promise((resolve) => {
			const ms = props.delay ?? 0.3
			if (startTimer != null) clearTimeout(startTimer!)
			startTimer = setTimeout(() => {
				resolve(true)
			}, ms * 1000)
		})
	}


	const reset = async () => {
		await nextTick()
		if (startTimer != null) clearTimeout(startTimer!)
		await startSleep()
		if (wrapperRef.value == null || contentRef.value == null) return

		state.duration = 0
		state.offset = 0

		const wrapperRet = await wrapperRef.value!.getBoundingClientRectAsync()!
		const contentRet = await contentRef.value!.getBoundingClientRectAsync()!
		const wrapperWidth = wrapperRet.width
		const contentWidth = contentRet.width
		if ((props.scrollable == true || contentWidth > wrapperWidth) && props.wrapable == false) {
			if (transitionTimer != null) clearTimeout(transitionTimer!)
			transitionTimer = setTimeout(() => {
				state.wrapWidth = wrapperWidth
				state.contentWidth = contentWidth
				state.offset = -contentWidth
				state.duration = contentWidth / props.speed

			}, 50)
		}
	}

	const onTransitionend = () => {
		state.duration = 0
		state.offset = state.wrapWidth
		if (endTimer != null) clearTimeout(endTimer!)
		endTimer = setTimeout(() => {
			state.duration = (state.contentWidth + state.wrapWidth) / props.speed
			state.offset = -state.contentWidth
		}, 50)
	}

	const handleClick = () => {
		emit('click')
	}

	const clickLeft = () => {
		emit('clickLeft')
	}

	const clickRight = () => {
		emit('clickRight')
	}

	const handleClose = () => {
		state.show = false
	}

	watch(() : (any | null)[] => [props.message, props.scrollable], async () => {
		await nextTick()
		console.log('ios change', " at uni_modules/rice-ui/components/rice-notice-bar/rice-notice-bar.uvue:149")
		reset()
	}, {
		deep: true,
	})

	const noticeBarStyle = computed(() => {
		const css = new Map<string, string>()
		if (hasStrValue(props.bgColor)) css.set('background-color', props.bgColor!)
		return css
	})

	const contentStyle = computed(() => {
		const css = new Map<string, string>()
		if (state.offset != 0) {
			css.set('transform', `translateX(${state.offset}px)`)
		}
		css.set('transition-duration', `${state.duration}s`)
		if (hasStrValue(props.color)) css.set('color', props.color!)
		if (props.fontSize != null) css.set('font-size', addUnit(props.fontSize!))
		return css
	})

	const noticeBarType = computed(() => isThemeColor(props.type) ? props.type : 'warning')

	const noticeBarClass = computed(() => {
		return [
			ns.b(""),
			ns.theme(),
			ns.m(noticeBarType.value),
			ns.is('wrapable', props.wrapable == true)
		]
	})











	const contentClass = computed(() => {
		const ellipsis = props.scrollable == false && props.wrapable == false
		return [
			ns.e('content'),
			ns.is('__content--wrapable', props.wrapable == true),
			ns.is('__content--ellipsis', ellipsis),

			ns.e(`content--${noticeBarType.value}`),

		]
	})

	const iconColor = computed<string>(() => {




		return hasStrValue(props.color) ? props.color! : ''

	})

	const iconClass = computed(() => ns.e(`content--${noticeBarType.value}`))

	onMounted(() => {
		reset()
	})

	__expose({
		reset
	})

return (): any | null => {

const _component_rice_icon = resolveEasyComponent("rice-icon",_easycom_rice_icon)

  return isTrue(unref(state).show)
    ? _cE("view", _uM({
        key: 0,
        class: _nC(unref(noticeBarClass)),
        style: _nS([unref(noticeBarStyle),_ctx.customStyle])
      }), [
        renderSlot(_ctx.$slots, "leftIcon", {}, (): any[] => [
          isTrue(unref(hasStrValue)(_ctx.leftIcon))
            ? _cV(_component_rice_icon, _uM({
                key: 0,
                name: _ctx.leftIcon,
                color: unref(iconColor),
                "custom-class": unref(iconClass),
                size: "18px",
                "custom-style": {width:'25px'},
                onClick: clickLeft
              }), null, 8 /* PROPS */, ["name", "color", "custom-class"])
            : _cC("v-if", true)
        ]),
        _cE("view", _uM({
          class: "rice-notice-bar__wrapper",
          ref_key: "wrapperRef",
          ref: wrapperRef,
          onClick: handleClick
        }), [
          _cE("text", _uM({
            class: _nC(unref(contentClass)),
            style: _nS(unref(contentStyle)),
            ref_key: "contentRef",
            ref: contentRef,
            onTransitionend: onTransitionend
          }), _tD(_ctx.message), 39 /* TEXT, CLASS, STYLE, NEED_HYDRATION */)
        ], 512 /* NEED_PATCH */),
        renderSlot(_ctx.$slots, "rightIcon", {}, (): any[] => [
          isTrue(unref(hasStrValue)(_ctx.rightIcon))
            ? _cV(_component_rice_icon, _uM({
                key: 0,
                name: _ctx.rightIcon,
                "custom-style": {width:'25px',textAlign:'right'},
                color: unref(iconColor),
                size: "18px",
                "custom-class": unref(iconClass),
                onClick: clickRight
              }), null, 8 /* PROPS */, ["name", "color", "custom-class"])
            : _cC("v-if", true)
        ]),
        isTrue(_ctx.closeable)
          ? _cV(_component_rice_icon, _uM({
              key: 0,
              name: "cross",
              "custom-style": {width:'25px',textAlign:'right'},
              color: unref(iconColor),
              "custom-class": unref(iconClass),
              size: "18px",
              onClick: handleClose
            }), null, 8 /* PROPS */, ["color", "custom-class"])
          : _cC("v-if", true)
      ], 6 /* CLASS, STYLE */)
    : _cC("v-if", true)
}
}

})
export default __sfc__
export type RiceNoticeBarComponentPublicInstance = InstanceType<typeof __sfc__>;
const GenUniModulesRiceUiComponentsRiceNoticeBarRiceNoticeBarStyles = [_uM([["rice-notice-bar", _pS(_uM([["position", "relative"], ["flexDirection", "row"], ["alignItems", "center"], ["minHeight", 45], ["paddingTop", 0], ["paddingRight", "var(--rice-padding-md)"], ["paddingBottom", 0], ["paddingLeft", "var(--rice-padding-md)"]]))], ["rice-notice-bar--primary", _pS(_uM([["backgroundColor", "var(--rice-primary-color-1)"]]))], ["rice-notice-bar--warning", _pS(_uM([["backgroundColor", "var(--rice-warning-color-1)"]]))], ["rice-notice-bar--success", _pS(_uM([["backgroundColor", "var(--rice-success-color-1)"]]))], ["rice-notice-bar--error", _pS(_uM([["backgroundColor", "var(--rice-error-color-1)"]]))], ["rice-notice-bar__wrapper", _pS(_uM([["flexGrow", 1], ["flexShrink", 1], ["flexBasis", "0%"], ["flexDirection", "row"], ["alignItems", "center"], ["height", "100%"]]))], ["rice-notice-bar__content", _pS(_uM([["position", "absolute"], ["whiteSpace", "nowrap"], ["transform", "translateX(0px)"], ["transitionProperty", "transform"], ["transitionTimingFunction", "linear"], ["fontSize", "var(--rice-font-size-basic)"], ["lineHeight", 1.6]]))], ["rice-notice-bar__content--wrapable", _pS(_uM([["position", "relative"], ["whiteSpace", "normal"]]))], ["rice-notice-bar__content--ellipsis", _pS(_uM([["textOverflow", "ellipsis"], ["whiteSpace", "nowrap"], ["width", "100%"]]))], ["rice-notice-bar__content--primary", _pS(_uM([["color", "var(--rice-primary-color)"]]))], ["rice-notice-bar__content--warning", _pS(_uM([["color", "var(--rice-warning-color)"]]))], ["rice-notice-bar__content--success", _pS(_uM([["color", "var(--rice-success-color)"]]))], ["rice-notice-bar__content--error", _pS(_uM([["color", "var(--rice-error-color)"]]))], ["rice-notice-bar--wrapable", _pS(_uM([["paddingTop", 14], ["paddingRight", "var(--rice-padding-md)"], ["paddingBottom", 14], ["paddingLeft", "var(--rice-padding-md)"]]))], ["@TRANSITION", _uM([["rice-notice-bar__content", _uM([["property", "transform"], ["timingFunction", "linear"]])]])]])]
