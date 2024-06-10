<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="设备名称" prop="deviceName">
        <el-input
          v-model="queryParams.deviceName"
          placeholder="请输入设备名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="设备定位" prop="location">
        <el-input
          v-model="queryParams.location"
          placeholder="请输入设备定位"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="设备纬度" prop="latitude">
        <el-input
          v-model="queryParams.latitude"
          placeholder="请输入设备纬度"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="设备经度" prop="longitude">
        <el-input
          v-model="queryParams.longitude"
          placeholder="请输入设备经度"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否可用" prop="isactive">
        <el-input
          v-model="queryParams.isactive"
          placeholder="请输入是否可用"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="设备描述" prop="description">
        <el-input
          v-model="queryParams.description"
          placeholder="请输入设备描述"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['lot:devices:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['lot:devices:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['lot:devices:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['lot:devices:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="devicesList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="设备ID" align="center" prop="deviceId" />
      <el-table-column label="设备名称" align="center" prop="deviceName" />
      <el-table-column label="设备位置" align="center" prop="location" />
      <el-table-column label="是否可用" align="center" prop="isactive" />
      <el-table-column label="设备描述" align="center" prop="description" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['lot:devices:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['lot:devices:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改Lot设备管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="设备名称" prop="deviceName">
          <el-input v-model="form.deviceName" placeholder="请输入设备名称" />
        </el-form-item>
        <el-form-item label="设备定位" prop="location">
          <el-input v-model="form.location" placeholder="请输入设备定位" />
        </el-form-item>
        <el-form-item label="设备图片" prop="picture">
          <el-input v-model="form.picture" placeholder="请输入设备图片" />
        </el-form-item>
        <el-form-item label="设备主题" prop="topic">
          <el-input v-model="form.topic" placeholder="请输入设备主题" />
        </el-form-item>
        <el-form-item label="设备纬度" prop="latitude">
          <el-input v-model="form.latitude" placeholder="请输入设备纬度" />
        </el-form-item>
        <el-form-item label="设备经度" prop="longitude">
          <el-input v-model="form.longitude" placeholder="请输入设备经度" />
        </el-form-item>
        <el-form-item label="设备描述" prop="description">
          <el-input v-model="form.description" placeholder="请输入设备描述" />
        </el-form-item>
        <el-divider content-position="center">LOT 传感器管理信息</el-divider>
        <el-row :gutter="10" class="mb8">
          <el-col :span="1.5">
            <el-button type="primary" icon="el-icon-plus" size="mini" @click="handleAddLotSensors">添加</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" icon="el-icon-delete" size="mini" @click="handleDeleteLotSensors">删除</el-button>
          </el-col>
        </el-row>
        <el-table :data="lotSensorsList" :row-class-name="rowLotSensorsIndex" @selection-change="handleLotSensorsSelectionChange" ref="lotSensors">
          <el-table-column type="selection" width="50" align="center" />
          <el-table-column label="序号" align="center" prop="index" width="50"/>
          <el-table-column label="传感器名称" prop="sensorName" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.sensorName" placeholder="请输入传感器名称" />
            </template>
          </el-table-column>
          <el-table-column label="传感器种类" prop="sensorType" width="150">
            <template slot-scope="scope">
              <el-select v-model="scope.row.sensorType" placeholder="请选择传感器种类">
                <el-option label="请选择字典生成" value="" />
              </el-select>
            </template>
          </el-table-column>
          <el-table-column label="传感器标签" prop="sensorTag" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.sensorTag" placeholder="请输入传感器标签" />
            </template>
          </el-table-column>
          <el-table-column label="是否可用" prop="isactive" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.isactive" placeholder="请输入是否可用" />
            </template>
          </el-table-column>
        </el-table>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listDevices, getDevices, delDevices, addDevices, updateDevices } from "@/api/lot/devices";

export default {
  name: "Devices",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 子表选中数据
      checkedLotSensors: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // Lot设备管理表格数据
      devicesList: [],
      // LOT 传感器管理表格数据
      lotSensorsList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        deviceId: null,
        deviceName: null,
        deviceType: null,
        deviceConnectType: null,
        location: null,
        topic: null,
        latitude: null,
        longitude: null,
        isactive: null,
        description: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        deviceName: [
          { required: true, message: "设备名称不能为空", trigger: "blur" }
        ],
        deviceType: [
          { required: true, message: "设备类型不能为空", trigger: "change" }
        ],
        deviceConnectType: [
          { required: true, message: "设备连接类型不能为空", trigger: "change" }
        ],
        location: [
          { required: true, message: "设备定位不能为空", trigger: "blur" }
        ],
        topic: [
          { required: true, message: "设备主题？不能为空", trigger: "blur" }
        ],
        isactive: [
          { required: true, message: "是否可用不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询Lot设备管理列表 */
    getList() {
      this.loading = true;
      listDevices(this.queryParams).then(response => {
        this.devicesList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        deviceId: null,
        deviceName: null,
        deviceType: null,
        deviceConnectType: null,
        location: null,
        picture: null,
        topic: null,
        latitude: null,
        longitude: null,
        isactive: null,
        description: null
      };
      this.lotSensorsList = [];
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.deviceId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加Lot设备管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const deviceId = row.deviceId || this.ids
      getDevices(deviceId).then(response => {
        this.form = response.data;
        this.lotSensorsList = response.data.lotSensorsList;
        this.open = true;
        this.title = "修改Lot设备管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          this.form.lotSensorsList = this.lotSensorsList;
          if (this.form.deviceId != null) {
            updateDevices(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addDevices(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const deviceIds = row.deviceId || this.ids;
      this.$modal.confirm('是否确认删除Lot设备管理编号为"' + deviceIds + '"的数据项？').then(function() {
        return delDevices(deviceIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
	/** LOT 传感器管理序号 */
    rowLotSensorsIndex({ row, rowIndex }) {
      row.index = rowIndex + 1;
    },
    /** LOT 传感器管理添加按钮操作 */
    handleAddLotSensors() {
      let obj = {};
      obj.sensorName = "";
      obj.sensorType = "";
      obj.sensorTag = "";
      obj.isactive = "";
      this.lotSensorsList.push(obj);
    },
    /** LOT 传感器管理删除按钮操作 */
    handleDeleteLotSensors() {
      if (this.checkedLotSensors.length == 0) {
        this.$modal.msgError("请先选择要删除的LOT 传感器管理数据");
      } else {
        const lotSensorsList = this.lotSensorsList;
        const checkedLotSensors = this.checkedLotSensors;
        this.lotSensorsList = lotSensorsList.filter(function(item) {
          return checkedLotSensors.indexOf(item.index) == -1
        });
      }
    },
    /** 复选框选中数据 */
    handleLotSensorsSelectionChange(selection) {
      this.checkedLotSensors = selection.map(item => item.index)
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('lot/devices/export', {
        ...this.queryParams
      }, `devices_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
