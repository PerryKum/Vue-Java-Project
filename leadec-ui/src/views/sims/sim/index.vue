<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="80px">
      <el-form-item label="sim卡ID" prop="cardId">
        <el-input
          v-model="queryParams.cardId"
          placeholder="请输入sim卡ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="创建时间" prop="startData">
        <el-date-picker clearable
          v-model="queryParams.startData"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择创建时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="供应商" prop="supplier">
        <el-input
          v-model="queryParams.supplier"
          placeholder="请输入供应商"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="sim卡号码" prop="numberID">
        <el-input
          v-model="queryParams.numberID"
          placeholder="请输入sim卡号码"
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
          v-hasPermi="['sims:sim:add']"
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
          v-hasPermi="['sims:sim:edit']"
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
          v-hasPermi="['sims:sim:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['sims:sim:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="simList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="sim卡ID" align="center" prop="cardId" />
      <el-table-column label="创建时间" align="center" prop="startData" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.startData, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="供应商" align="center" prop="supplier" />
      <el-table-column label="sim卡号码" align="center" prop="numberID" />
      <el-table-column label="sim卡图片" align="center" prop="picture" />
      <el-table-column label="是否可用" align="center" prop="isactive" />
      <el-table-column label="消费等级" align="center" prop="costLevel" />
      <el-table-column label="SIMICMI" align="center" prop="SIMICMI" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['sims:sim:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['sims:sim:remove']"
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

    <!-- 添加或修改SIM 卡管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="600px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="100px">
        <el-form-item label="创建时间" prop="startData">
          <el-date-picker clearable
            v-model="form.startData"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择创建时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="供应商" prop="supplier">
          <el-input v-model="form.supplier" placeholder="请输入供应商" />
        </el-form-item>
        <el-form-item label="sim卡号码" prop="numberID">
          <el-input v-model="form.numberID" placeholder="请输入sim卡号码" />
        </el-form-item>
        <el-form-item label="sim卡图片" prop="picture">
          <el-input v-model="form.picture" placeholder="请输入sim卡图片" />
        </el-form-item>
        <el-form-item label="消费等级" prop="costLevel">
          <el-input v-model="form.costLevel" placeholder="请输入消费等级" />
        </el-form-item>
        <el-form-item label="SIMICMI" prop="SIMICMI">
          <el-input v-model="form.SIMICMI" placeholder="请输入SIMICMI" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listSim, getSim, delSim, addSim, updateSim } from "@/api/sims/sim";

export default {
  name: "Sim",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // SIM 卡管理表格数据
      simList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        cardId: null,
        startData: null,
        supplier: null,
        numberID: null,
        isactive: null,
        costLevel: null,
        SIMICMI: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        startData: [
          { required: true, message: "创建时间不能为空", trigger: "blur" }
        ],
        numberID: [
          { required: true, message: "sim卡号码不能为空", trigger: "blur" }
        ],
        isactive: [
          { required: true, message: "是否可用不能为空", trigger: "change" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询SIM 卡管理列表 */
    getList() {
      this.loading = true;
      listSim(this.queryParams).then(response => {
        this.simList = response.rows;
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
        cardId: null,
        startData: null,
        supplier: null,
        numberID: null,
        picture: null,
        isactive: null,
        costLevel: null,
        SIMICMI: null
      };
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
      this.ids = selection.map(item => item.cardId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加SIM 卡管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const cardId = row.cardId || this.ids
      getSim(cardId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改SIM 卡管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.cardId != null) {
            updateSim(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addSim(this.form).then(response => {
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
      const cardIds = row.cardId || this.ids;
      this.$modal.confirm('是否确认删除SIM 卡管理编号为"' + cardIds + '"的数据项？').then(function() {
        return delSim(cardIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('sims/sim/export', {
        ...this.queryParams
      }, `sim_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
