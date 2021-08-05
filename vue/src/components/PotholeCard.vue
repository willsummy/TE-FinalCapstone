<template>
  <div>
      <div>{{pothole.user_id}}</div>
      <div>{{pothole.date_reported}}</div>
      <div>{{pothole.time_reported}}</div>
      <div>{{pothole.address}}</div>
      <div>{{pothole.latitude}}</div>
      <div>{{pothole.longitude}}</div>
      <div>{{pothole.description}}</div>
      <div>{{pothole.size}}</div>
  </div>
</template>

<script>

export default {
    name: 'pothole-card',
    props: ['pothole']

}
</script>

<style>

</style>