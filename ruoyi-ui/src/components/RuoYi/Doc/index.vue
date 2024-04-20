<template>
  <div>
    <svg-icon icon-class="question" @click="goto" />
  </div>
</template>

<script>
export default {
  name: 'RuoYiDoc',
  data() {
    return {
      url: 'http://vue_blog-tqei477i-perrykum.4everland.app/'
    }
  },
  methods: {
    goto() {
      window.open(this.url)
    }
  }
}
</script>