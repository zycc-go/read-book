type BadgeProps = { __$originalPosition?: UTSSourceMapPosition<"BadgeProps", "componnets/MyTabs.uvue", 26, 7>;
		isDot ?: boolean;
		value ?: number;
		showZero ?: boolean;
	}

	type TabOption = { __$originalPosition?: UTSSourceMapPosition<"TabOption", "componnets/MyTabs.uvue", 32, 7>;
		name : string;
		value ?: string | number;
		disabled ?: boolean;
		badge ?: BadgeProps;
	}

	type TabClickEvent = { __$originalPosition?: UTSSourceMapPosition<"TabClickEvent", "componnets/MyTabs.uvue", 39, 7>;
		index : number;
		name : string;
		value ?: string | number;
		disabled : boolean;
	}

	type TabChangeEvent = { __$originalPosition?: UTSSourceMapPosition<"TabChangeEvent", "componnets/MyTabs.uvue", 46, 7>;
		index : number;
		name : string;
		value ?: string | number;
		disabled : boolean;
	}

	type PropsType = { __$originalPosition?: UTSSourceMapPosition<"PropsType", "componnets/MyTabs.uvue", 53, 7>;
		list : TabOption[];
		shrink ?: boolean;
		titleActiveColor ?: string;
		titleInactiveColor ?: string;
		bgColor ?: string;
		height ?: string | number;
		lineColor ?: string;
		lineWidth ?: string | number;
		lineHeight ?: string | number;
		itemStyle ?: UTSJSONObject;
		activeStyle ?: UTSJSONObject;
		inactiveStyle ?: UTSJSONObject;
		customStyle ?: UTSJSONObject;
	}

	// const emit = defineEmits<{ clickTab: [], change : [] }>()
	
const __sfc__ = defineComponent({
  __name: 'MyTabs',
  props: /*#__PURE__*/mergeModels({
    list: { type: Array as PropType<TabOption[]>, required: true, default: () => [] as TabOption[] },
    shrink: { type: Boolean, required: false, default: false },
    titleActiveColor: { type: String, required: false },
    titleInactiveColor: { type: String, required: false },
    bgColor: { type: String, required: false },
    height: { type: [String, Number], required: false },
    lineColor: { type: String, required: false },
    lineWidth: { type: [String, Number], required: false, default: () => '20px' },
    lineHeight: { type: [String, Number], required: false },
    itemStyle: { type: UTSJSONObject, required: false, default: () => ({}) },
    activeStyle: { type: UTSJSONObject, required: false, default: () => ({}) },
    inactiveStyle: { type: UTSJSONObject, required: false, default: () => ({}) },
    customStyle: { type: UTSJSONObject, required: false, default: () => ({}) }
  }, {
    "modelValue": { type: Number, default: 0 },
  }),
  emits: /*#__PURE__*/mergeModels(['clickTab', 'change'], ["update:modelValue"]),
  setup(__props, __setupCtx: SetupContext) {
const __expose = __setupCtx.expose
const __ins = getCurrentInstance()!;
const _ctx = __ins.proxy as InstanceType<typeof __sfc__>;
const _cache = __ins.renderCache;

	function emit(event: string, ...do_not_transform_spread: Array<any | null>) {
__ins.emit(event, ...do_not_transform_spread)
}

	const props = __props

	const modelValue = useModel<Number>(__ins.props, "modelValue")

	let lastValue = 0
	const instance = getCurrentInstance()
	const scrollLeft = ref(0)
	const tabScrollRef = shallowRef<UniElement | null>(null)
	const indicatorRef = shallowRef<UniElement | null>(null)
	const tabsRef = shallowRef<UniElement | null>(null)
	const tabsNodeInfo = shallowRef<any[]>([])

	// 添加单位
	const addUnit = (value : string | number) : string => {
		if (typeof value === 'number') {
			return value + 'px'
		}
		return value
	}

	// 获取像素值
	const getPxNum = (value : string | number, defaultVal : number) : number => {
		if (typeof value === 'number') {
			return value
		}
		if (value === '100%') {
			return defaultVal
		}
		const num = parseInt(value)
		return isNaN(num) ? defaultVal : num
	}

	// 检查是否有字符串值
	const hasStrValue = (value : any) : boolean => {
		return value != null && value !== ''
	}

	// 更新指示器位置
	const updateTabIndicator = (moveTo ?: number) => {
		if (moveTo == null) moveTo = 0
		const tabLen = tabsNodeInfo.value.length
		if (moveTo < 0 || moveTo >= tabLen) return

		const moveToRect = tabsNodeInfo.value[moveTo]
		const moveToWidth = moveToRect?.width ?? 0

		if (tabLen <= 0 || moveTo >= tabLen) return

		// 计算偏移量
		const offsetLeft = tabsNodeInfo.value.slice(0, moveTo).reduce((cur, pre) => {
			return cur + (pre?.width ?? 0)
		}, 0)

		let lineWidth = getPxNum(props.lineWidth!, moveToWidth)

		// 设置滑块宽度
		indicatorRef.value?.style.setProperty('width', lineWidth + 'px')

		// 计算滑块位置
		let x = offsetLeft + (moveToWidth - lineWidth) / 2
		indicatorRef.value?.style.setProperty('transform', `translateX(${x}px)`)

		// 滚动到合适位置
		tabScrollRef.value?.getBoundingClientRectAsync()?.then((res : DOMRect) => {
			scrollLeft.value = x - res.width / 2
		})
	}

	// 重新计算尺寸
	const resize = async () => {
		await nextTick()
		uni.createSelectorQuery().in(instance).selectAll('.my-tabs__item').boundingClientRect(res => {
			const nodeInfoArr = res as any[]
			tabsNodeInfo.value = nodeInfoArr
			updateTabIndicator(modelValue.value)
		}).exec()
	}

	// 标签点击事件
	const tabsItemClick = (tab : TabOption, index : number) => {
		emit('clickTab', { index, name: tab.name, value: tab.value, disabled: tab.disabled ?? false } as TabClickEvent)

		if (modelValue.value == index || tab.disabled == true) return

		modelValue.value = index
		lastValue = index

		emit('change', {
			index,
			name: tab.name,
			value: tab.value,
			disabled: tab.disabled ?? false
		} as TabChangeEvent)

		updateTabIndicator(index)
	}

	// 监听 modelValue 变化
	watch(modelValue, (newVal : number) => {
		if (lastValue != newVal) {
			lastValue = newVal
			updateTabIndicator(newVal)
		}
	})

	// 监听 props 变化
	watch([
		() => props.lineWidth,
		() => props.lineHeight,
		() => props.list
	], async () => {
		await nextTick()
		resize()
	}, { deep: true })

	// 计算 tabs 样式
	const tabsStyle = computed(() => {
		const css = new Map<string, string>()
		if (props.height != null) css.set('height', addUnit(props.height!))
		if (hasStrValue(props.bgColor)) css.set('background-color', props.bgColor!)
		return css
	})

	// 获取文本样式
	const getTextStyle = (tab : TabOption, index : number) => {
		const textCss = new Map<string, string>()

		// 应用 itemStyle
		if (props.itemStyle) {
			for (var key in props.itemStyle) {
				textCss.set(key, props.itemStyle![key] as string)
			}
		}

		if (modelValue.value == index) {
			// 应用 activeStyle
			if (props.activeStyle) {
				for (var key in props.activeStyle) {
					textCss.set(key, props.activeStyle![key] as string)
				}
			}
			// 应用选中颜色
			if (hasStrValue(props.titleActiveColor)) {
				textCss.set('color', props.titleActiveColor!)
			}
		} else {
			// 应用 inactiveStyle
			if (props.inactiveStyle) {
				for (var key in props.inactiveStyle) {
					textCss.set(key, props.inactiveStyle![key] as string)
				}
			}
			// 应用未选中颜色
			if (hasStrValue(props.titleInactiveColor) && tab.disabled != true) {
				textCss.set('color', props.titleInactiveColor!)
			}
		}

		return textCss
	}

	// 指示器样式
	const indicatorStyle = computed(() => {
		const css = new Map<string, string>()
		if (props.lineHeight != null) css.set('height', addUnit(props.lineHeight!))
		if (hasStrValue(props.lineColor)) css.set('background-color', props.lineColor!)
		return css
	})

	// 组件类名
	const tabsClass = computed(() => {
		return ['my-tabs']
	})

	// 标签项类名
	const tabsItemClass = computed(() => {
		return ['my-tabs__item', props.shrink ? 'my-tabs__item--shrink' : '']
	})

	// 挂载时初始化
	onMounted(() => {
		resize()
	})

	// 暴露方法
	__expose({
		resize
	})

return (): any | null => {

  return _cE("view", _uM({
    class: _nC(unref(tabsClass)),
    style: _nS([unref(tabsStyle), _ctx.customStyle]),
    ref_key: "tabsRef",
    ref: tabsRef
  }), [
    _cE("scroll-view", _uM({
      ref_key: "tabScrollRef",
      ref: tabScrollRef,
      class: "my-tabs__scroll",
      direction: "horizontal",
      "show-scrollbar": false,
      "scroll-left": unref(scrollLeft),
      "scroll-with-animation": "true"
    }), [
      _cE("view", _uM({ class: "my-tabs__scroll-inner" }), [
        _cE(Fragment, null, RenderHelpers.renderList(_ctx.list, (item, index, __index, _cached): any => {
          return _cE("view", _uM({
            key: item.name,
            class: _nC(unref(tabsItemClass)),
            "data-name": item.name,
            onClick: () => {tabsItemClick(item, index)}
          }), [
            isTrue(item.badge)
              ? _cE("view", _uM({
                  key: 0,
                  class: "my-tabs__badge"
                }), [
                  isTrue(item.badge.isDot)
                    ? _cE("text", _uM({
                        key: 0,
                        class: "my-tabs__badge-dot"
                      }))
                    : isTrue(item.badge.value)
                      ? _cE("text", _uM({
                          key: 1,
                          class: "my-tabs__badge-value"
                        }), _tD(item.badge.value), 1 /* TEXT */)
                      : _cC("v-if", true)
                ])
              : _cC("v-if", true),
            _cE("text", _uM({
              style: _nS(getTextStyle(item, index)),
              class: _nC(["my-tabs__item__text", _uM({
							'my-tabs__item__active': index == modelValue.value,
							'my-tabs__item__disabled': item.disabled
						})])
            }), _tD(item.name), 7 /* TEXT, CLASS, STYLE */)
          ], 10 /* CLASS, PROPS */, ["data-name", "onClick"])
        }), 128 /* KEYED_FRAGMENT */),
        _cE("view", _uM({
          ref_key: "indicatorRef",
          ref: indicatorRef,
          style: _nS(unref(indicatorStyle)),
          class: "my-tabs__indicator"
        }), null, 4 /* STYLE */)
      ])
    ], 8 /* PROPS */, ["scroll-left"])
  ], 6 /* CLASS, STYLE */)
}
}

})
export default __sfc__
const GenComponnetsMyTabsStyles = [_uM([["my-tabs", _pS(_uM([["display", "flex"], ["flexDirection", "row"], ["height", 44], ["backgroundColor", "var(--rice-tabs-background, #f5f5f5)"]]))], ["my-tabs__scroll", _pS(_uM([["position", "relative"], ["display", "flex"], ["flexDirection", "row"], ["height", "100%"], ["flexGrow", 1], ["flexShrink", 1], ["flexBasis", "0%"], ["overflow", "hidden"]]))], ["my-tabs__scroll-inner", _pS(_uM([["position", "relative"], ["flexGrow", 1], ["flexShrink", 1], ["flexBasis", "0%"], ["height", "100%"], ["display", "flex"], ["flexDirection", "row"], ["alignItems", "center"]]))], ["my-tabs__item", _pS(_uM([["position", "relative"], ["display", "flex"], ["flexDirection", "row"], ["alignItems", "center"], ["justifyContent", "center"], ["paddingTop", 0], ["paddingRight", 12], ["paddingBottom", 0], ["paddingLeft", 12], ["flexGrow", 1], ["flexShrink", 0], ["flexBasis", "auto"], ["overflow", "visible"], ["cursor", "pointer"]]))], ["my-tabs__item--shrink", _pS(_uM([["paddingTop", 0], ["paddingRight", 8], ["paddingBottom", 0], ["paddingLeft", 8], ["flexGrow", 0], ["flexShrink", 0], ["flexBasis", "auto"]]))], ["my-tabs__item__text", _pS(_uM([["transitionProperty", "color"], ["transitionDuration", "0.3s"], ["fontSize", "var(--rice-font-size-basic, 14px)"], ["color", "var(--rice-text-color-2, #666)"]]))], ["my-tabs__item__active", _pS(_uM([["color", "var(--rice-text-color, #333)"], ["fontWeight", "500"]]))], ["my-tabs__item__disabled", _pS(_uM([["color", "var(--rice-tabs-disabled-text-color, #ccc)"], ["cursor", "not-allowed"]]))], ["my-tabs__badge", _pS(_uM([["position", "absolute"], ["top", -4], ["right", -4], ["zIndex", 1]]))], ["my-tabs__badge-dot", _pS(_uM([["width", 6], ["height", 6], ["borderTopLeftRadius", "50%"], ["borderTopRightRadius", "50%"], ["borderBottomRightRadius", "50%"], ["borderBottomLeftRadius", "50%"], ["backgroundColor", "var(--rice-color-primary, #d81e06)"]]))], ["my-tabs__badge-value", _pS(_uM([["minWidth", 16], ["height", 16], ["paddingTop", 0], ["paddingRight", 4], ["paddingBottom", 0], ["paddingLeft", 4], ["borderTopLeftRadius", 8], ["borderTopRightRadius", 8], ["borderBottomRightRadius", 8], ["borderBottomLeftRadius", 8], ["backgroundColor", "var(--rice-color-primary, #d81e06)"], ["color", "#FFFFFF"], ["fontSize", 10], ["lineHeight", "16px"], ["textAlign", "center"]]))], ["my-tabs__indicator", _pS(_uM([["position", "absolute"], ["zIndex", 1], ["bottom", 2], ["left", 0], ["borderTopLeftRadius", 100], ["borderTopRightRadius", 100], ["borderBottomRightRadius", 100], ["borderBottomLeftRadius", 100], ["transitionProperty", "transform,width"], ["transitionDuration", "300ms"], ["width", 20], ["height", 3], ["backgroundColor", "var(--rice-color-primary, #d81e06)"]]))], ["@TRANSITION", _uM([["my-tabs__item__text", _uM([["property", "color"], ["duration", "0.3s"]])], ["my-tabs__indicator", _uM([["property", "transform,width"], ["duration", "300ms"]])]])]])]
