<template>
  <canvas
    id="captchaCanvas"
    @click="generateCaptcha"
    :style="{ width, height }"
  ></canvas>
</template>

<script setup lang="ts">
import { watch, onMounted} from "vue";
const emit = defineEmits(["getValue"]);
const props = defineProps({
  // 宽度
  width: {
    type: String,
    default: "100%",
  },
  // 高度
  height: {
    type: String,
    default: "100%",
  },
  //验证码数量
  number: {
    type: Number,
    default: 4,
  }, //验证码数量
  night: {
    type: Boolean,
    default: false,
  },
});
watch(
  () => props.night,
  () => {
    generateCaptcha();
  }
);
const generateCaptcha = () => {
  const canvas = document.getElementById("captchaCanvas")as HTMLCanvasElement;
  if (!canvas) return;
  const ctx = canvas.getContext("2d");
  if (!ctx) return;
  // 清除旧内容
  canvas.width = canvas.width;
  // 字符集
  const chars =
    "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
  let captchaText = "";
  // 设置背景颜色和一些基本样式
  ctx.fillStyle = props.night ? "#2d2c2c" : "#f9f9f9";
  ctx.fillRect(0, 0, canvas.width, canvas.height);
  // 绘制噪点
  for (let i = 0; i < 200; i++) {
    ctx.fillStyle = getRandomColor(0, 300);
    ctx.fillRect(
      Math.random() * canvas.width,
      Math.random() * canvas.height,
      1,
      1
    );
  }
  // 绘制干扰线
  for (let i = 0; i < 9; i++) {
    ctx.strokeStyle = getRandomColor(150, 255);
    ctx.beginPath();
    ctx.moveTo(Math.random() * canvas.width, Math.random() * canvas.height);
    ctx.lineTo(Math.random() * canvas.width, Math.random() * canvas.height);
    ctx.stroke();
  }
  // 生成验证码文本
  for (let i = 0; i < props.number; i++) {
    // 假设验证码长度为 5
    const randomIndex = Math.floor(Math.random() * chars.length);
    const char = chars[randomIndex];
    captchaText += char;
    drawChar(
      char,
      String(1 + (i * canvas.width) / props.number),
      String(canvas.height / 2 + 20),
      '70',
      getRandomColor(10, 50)
    );
  }
  //返回给父组件
  emit("getValue", captchaText);
};
const drawChar = (char:string, x:string, y:string, fontSize:string, fillStyle:string) => {
  const ctx = document.getElementById("captchaCanvas").getContext("2d");
  ctx.font = fontSize + "px Arial";
  ctx.fillStyle = fillStyle;
  ctx.fillText(char, x, y);
};

const getRandomColor = (min, max) => {
  const r = Math.floor(Math.random() * 256); // 0-255
  const g = Math.floor(Math.random() * 256);
  const b = Math.floor(Math.random() * 256);
  return `rgb(${r},${g},${b})`;
};
//暴露给父组件调用
defineExpose({ generateCaptcha });
onMounted(() => {
  generateCaptcha();
});
</script>

<style scoped>
#captchaCanvas {
  margin-bottom: 10px;
  display: block;
  user-select: none;
}
</style>


<!--<template>-->
<!--  <div class="s-canvas">-->
<!--    <canvas id="s-canvas" :width="props.contentWidth" :height="props.contentHeight"></canvas>-->
<!--  </div>-->
<!--</template>-->

<!--<script setup>-->
<!--import { onMounted, watch } from 'vue'-->

<!--// eslint-disable-next-line no-undef-->
<!--const props = defineProps({-->
<!--  identifyCode: {-->
<!--    type: String,-->
<!--    default: '1234'-->
<!--  },-->
<!--  fontSizeMin: {-->
<!--    type: Number,-->
<!--    default: 25-->
<!--  },-->
<!--  fontSizeMax: {-->
<!--    type: Number,-->
<!--    default: 35-->
<!--  },-->
<!--  backgroundColorMin: {-->
<!--    type: Number,-->
<!--    default: 255-->
<!--  },-->
<!--  backgroundColorMax: {-->
<!--    type: Number,-->
<!--    default: 255-->
<!--  },-->
<!--  colorMin: {-->
<!--    type: Number,-->
<!--    default: 0-->
<!--  },-->
<!--  colorMax: {-->
<!--    type: Number,-->
<!--    default: 160-->
<!--  },-->
<!--  lineColorMin: {-->
<!--    type: Number,-->
<!--    default: 40-->
<!--  },-->
<!--  lineColorMax: {-->
<!--    type: Number,-->
<!--    default: 180-->
<!--  },-->
<!--  dotColorMin: {-->
<!--    type: Number,-->
<!--    default: 0-->
<!--  },-->
<!--  dotColorMax: {-->
<!--    type: Number,-->
<!--    default: 255-->
<!--  },-->
<!--  contentWidth: {-->
<!--    type: Number,-->
<!--    default: 112-->
<!--  },-->
<!--  contentHeight: {-->
<!--    type: Number,-->
<!--    default: 40-->
<!--  }-->
<!--})-->
<!--// 生成一个随机数-->
<!--const randomNum = (min, max) => {-->
<!--  return Math.floor(Math.random() * (max - min) + min)-->
<!--}-->

<!--// 生成一个随机的颜色-->
<!--const randomColor = (min, max) => {-->
<!--  let r = randomNum(min, max)-->
<!--  let g = randomNum(min, max)-->
<!--  let b = randomNum(min, max)-->
<!--  return 'rgb(' + r + ',' + g + ',' + b + ')'-->
<!--}-->

<!--// 绘制干扰线-->
<!--const drawLine = (ctx) => {-->
<!--  for (let i = 0; i < 5; i++) {-->
<!--    ctx.strokeStyle = randomColor(props.lineColorMin, props.lineColorMax)-->
<!--    ctx.beginPath()-->
<!--    ctx.moveTo(randomNum(0, props.contentWidth), randomNum(0, props.contentHeight))-->
<!--    ctx.lineTo(randomNum(0, props.contentWidth), randomNum(0, props.contentHeight))-->
<!--    ctx.stroke()-->
<!--  }-->
<!--}-->
<!--//在画布上显示数据-->
<!--const drawText = (ctx, txt, i) => {-->
<!--  ctx.fillStyle = randomColor(props.colorMin, props.colorMax)-->
<!--  ctx.font = randomNum(props.fontSizeMin, props.fontSizeMax) + 'px SimHei'-->
<!--  let x = (i + 1) * (props.contentWidth / (props.identifyCode.length + 1))-->
<!--  let y = randomNum(props.fontSizeMax, props.contentHeight - 5)-->
<!--  var deg = randomNum(-45, 45)-->
<!--  // 修改坐标原点和旋转角度-->
<!--  ctx.translate(x, y)-->
<!--  ctx.rotate((deg * Math.PI) / 180)-->
<!--  ctx.fillText(txt, 0, 0)-->
<!--  // 恢复坐标原点和旋转角度-->
<!--  ctx.rotate((-deg * Math.PI) / 180)-->
<!--  ctx.translate(-x, -y)-->
<!--}-->
<!--// 绘制干扰点-->
<!--const drawDot = (ctx) => {-->
<!--  for (let i = 0; i < 80; i++) {-->
<!--    ctx.fillStyle = randomColor(0, 255)-->
<!--    ctx.beginPath()-->
<!--    ctx.arc(randomNum(0, props.contentWidth), randomNum(0, props.contentHeight), 1, 0, 2 * Math.PI)-->
<!--    ctx.fill()-->
<!--  }-->
<!--}-->
<!--//画图-->
<!--const drawPic = () => {-->
<!--  let canvas = document.getElementById('s-canvas')-->
<!--  let ctx = canvas.getContext('2d')-->
<!--  ctx.textBaseline = 'bottom'-->
<!--  // 绘制背景-->
<!--  ctx.fillStyle = randomColor(props.backgroundColorMin, props.backgroundColorMax)-->
<!--  ctx.fillRect(0, 0, props.contentWidth, props.contentHeight)-->
<!--  // 绘制文字-->
<!--  for (let i = 0; i < props.identifyCode.length; i++) {-->
<!--    drawText(ctx, props.identifyCode[i], i)-->
<!--  }-->
<!--  drawLine(ctx)-->
<!--  drawDot(ctx)-->
<!--}-->
<!--//组件挂载-->
<!--onMounted(() => {-->
<!--  drawPic()-->
<!--})-->
<!--// 监听-->
<!--watch(-->
<!--  () => props.identifyCode,-->
<!--  () => {-->
<!--    drawPic()-->
<!--  }-->
<!--)-->
<!--</script>-->
<!--<style scoped lang="scss">-->
<!--.s-canvas {-->
<!--  cursor: pointer;-->
<!--}-->
<!--</style>-->
