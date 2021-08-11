import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    potholes: [],
    filterType: '',
    filter: "",
    currentServices: null
  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user',JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    },
    SET_POTHOLES(state, potholes) {
      state.potholes = potholes;
    },
    ADD_POTHOLE(state, pothole) {
      state.potholes.push(pothole);
    },

    SET_FILTER(state, filterAndType) {
      state.filter = filterAndType.filter;
      state.filterType = filterAndType.filterType;
    },
    RESET_FILTER(state) {
      state.filter = "";
    },
    SET_FILTER_TYPE(state, type) {
      state.filterType = type;
    },
    RESET_FILTER_TYPE(state) {
      state.filterType = ''
    },

    DELETE_POTHOLE(state, id) {
      state.potholes.splice(
        state.potholes.findIndex(potholes => potholes.pothole_id === id), 1
      )
    },

      SET_SERVICES(state, services) {
      state.currentServices = services;
    },
    DELETE_SERVICE(state) {
      state.currentServices = null;
    }

  }
})
