<template>
  <div>
      <p>{{pothole.user_id}}</p>
      <p>{{pothole.date_reported}}</p>
      <p>{{pothole.time_reported}}</p>
      <p>{{pothole.address}}</p>
      <p>{{pothole.latitude}}</p>
      <p>{{pothole.longitude}}</p>
      <p>{{pothole.description}}</p>
      <p>{{pothole.size}}</p>
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
