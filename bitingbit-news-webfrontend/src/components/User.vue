<template>
  <q-page>
    <div v-if="user">
      <h4>User Details</h4>
      <div>
        <span for="firstname">First Name: </span>
        <br v-if="isEditing" />

        <input
          type="text"
          v-model="user.firstName"
          :disabled="!isEditing"
          :class="{ view: !isEditing }"
        />
      </div>
      <div>
        <span>Surname: </span>
        <br v-if="isEditing" />

        <input
          type="text"
          v-model="user.surname"
          :disabled="!isEditing"
          :class="{ view: !isEditing }"
        />
      </div>
      <div>
        <span>Email: </span>
        <br v-if="isEditing" />
        <input
          type="text"
          v-model="user.emailAddress"
          :disabled="!isEditing"
          :class="{ view: !isEditing }"
        />
      </div>
      <div>
        <div v-if="!isEditing">
          <span>Role: </span>

          <span>{{ user?.userRole?.role }}</span>
        </div>
        <div v-else>
          <label for="role">Role: </label>
          <br />
          <select
            v-model="selectedRole"
            v-if="isEditing"
            :class="{ view: !isEditing }"
            @change="updateRole($event)"
          >
            // eslint-disable-next-line vue/require-v-for-key //
            eslint-disable-next-line vue/require-v-for-key //
            eslint-disable-next-line vue/require-v-for-key
            <option
              v-for="item in userRoles"
              :key="item.id.value"
              :value="item.role"
            >
              <span> {{ item.role }} </span>
            </option>
          </select>
        </div>
      </div>
      <button @click="edit" class="buttons" v-if="!isEditing">Edit</button>
      <button @click="save" class="buttons" v-else-if="isEditing">Save</button>

      <button v-if="isEditing" class="buttons" @click="cancel">Cancel</button>
    </div>
  </q-page>
</template>

<style>
.view {
  border-color: transparent;
  background-color: initial;
  color: initial;
  margin-bottom: 3px;
}

.buttons {
  margin-top: 25px;
}
</style>

<script>
import axios from 'axios';
import { onMounted, ref } from 'vue';

export default {
  name: 'User',

  setup() {
    const user = ref({});
    const isEditing = ref(false);
    const userRoles = ref([]);
    const selectedRole = ref({});

    const fetchUserRoles = async () => {
      try {
        const axiosConfig = {
          headers: {
            'Content-Type': 'application/json;charset=UTF-8',
            'Access-Control-Allow-Origin': '*',
          },
        };
        const response = await axios.get(
          'http://localhost:8080/roles',
          // eslint-disable-next-line comma-dangle
          axiosConfig
        );
        userRoles.value = response.data;
      } catch (err) {
        throw new Error(err);
      }
    };

    const fetchUser = async () => {
      try {
        const axiosConfig = {
          headers: {
            'Content-Type': 'application/json;charset=UTF-8',
            'Access-Control-Allow-Origin': '*',
          },
        };
        const response = await axios.get(
          'http://localhost:8080/user/1',
          // eslint-disable-next-line comma-dangle
          axiosConfig
        );
        user.value = response.data;
      } catch (err) {
        throw new Error(err);
      }
    };

    const cancel = () => {
      isEditing.value = false;
      fetchUser();
    };

    const save = async () => {
      isEditing.value = !isEditing.value;
      // eslint-disable-next-line no-plusplus
      for (let i = 0; i < userRoles.value.length; i++) {
        if (userRoles.value[i].role === selectedRole.value) {
          selectedRole.value = userRoles.value[i];
          break;
        }
      }

      try {
        const axiosConfig = {
          headers: {
            'Content-Type': 'application/json;charset=UTF-8',
            'Access-Control-Allow-Origin': '*',
          },
        };
        const response = await axios.put(
          'http://localhost:8080/user/1',
          {
            ...user.value,
            userRole: selectedRole.value,
          },
          // eslint-disable-next-line comma-dangle
          axiosConfig
        );
        if (response.status === 200) {
          fetchUser();
        }
      } catch (err) {
        throw new Error(err);
      }
    };

    const edit = () => {
      isEditing.value = !isEditing.value;
    };

    onMounted(() => {
      fetchUser();
      fetchUserRoles();
    });

    return {
      save,
      edit,
      isEditing,
      user,
      userRoles,
      fetchUser,
      fetchUserRoles,
      selectedRole,
      cancel,
    };
  },
};
</script>
