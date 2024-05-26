<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="现场ID" prop="siteId">
        <el-input
          v-model="queryParams.siteId"
          placeholder="请输入现场ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="现场名称" prop="siteName">
        <el-input
          v-model="queryParams.siteName"
          placeholder="请输入现场名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="现场地址" prop="address">
        <el-input
          v-model="queryParams.address"
          placeholder="请输入现场地址"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="现场经度" prop="longitude">
        <el-input
          v-model="queryParams.longitude"
          placeholder="请输入现场经度"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="现场纬度" prop="latitude">
        <el-input
          v-model="queryParams.latitude"
          placeholder="请输入现场纬度"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="现场描述" prop="description">
        <el-input
          v-model="queryParams.description"
          placeholder="请输入现场描述"
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
          v-hasPermi="['sites:site:add']"
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
          v-hasPermi="['sites:site:edit']"
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
          v-hasPermi="['sites:site:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['sites:site:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="siteList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="现场ID" align="center" prop="siteId" />
      <el-table-column label="现场logo" align="center" prop="logo" />
      <el-table-column label="现场名称" align="center" prop="siteName" />
      <el-table-column label="现场地址" align="center" prop="address" />
      <el-table-column label="是否可用" align="center" prop="isactive" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['sites:site:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['sites:site:remove']"
          >删除</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-view"
            @click="handleDetail(scope.row)"
          >详情</el-button>
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

    <!-- 添加或修改现场管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="现场logo" prop="logo">
          <el-input v-model="form.logo" placeholder="请输入现场logo" />
        </el-form-item>
        <el-form-item label="现场名称" prop="siteName">
          <el-input v-model="form.siteName" placeholder="请输入现场名称" />
        </el-form-item>
        <el-form-item label="现场简称" prop="siteShortName">
          <el-input v-model="form.siteShortName" placeholder="请输入现场简称" />
        </el-form-item>
        <el-form-item label="权限字段" prop="siteKey">
          <el-input v-model="form.siteKey" placeholder="请输入权限字段" />
        </el-form-item>
        <el-form-item label="现场地址" prop="address">
          <el-input v-model="form.address" placeholder="请输入现场地址" />
        </el-form-item>
        <el-form-item label="服务线" prop="serviceLine">
          <el-input v-model="form.serviceLine" placeholder="请输入服务线" />
        </el-form-item>
        <el-form-item label="现场图片" prop="picture">
          <el-input v-model="form.picture" placeholder="请输入现场图片" />
        </el-form-item>
        <el-form-item label="是否可用" prop="isactive">
          <el-input v-model="form.isactive" placeholder="请输入是否可用" />
        </el-form-item>
        <el-form-item label="现场经度" prop="longitude">
          <el-input v-model="form.longitude" placeholder="请输入现场经度" />
        </el-form-item>
        <el-form-item label="现场纬度" prop="latitude">
          <el-input v-model="form.latitude" placeholder="请输入现场纬度" />
        </el-form-item>
        <el-form-item label="现场描述" prop="description">
          <el-input v-model="form.description" placeholder="请输入现场描述" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>

    <!-- 详情对话框 -->
    <el-dialog :visible.sync="openDetailDialog" title="站点详情">
      <div>
        <p><strong>现场logo:</strong> <img :src="detail.logo" alt="现场Logo" v-if="detail.logo"></p>
        <p><strong>现场名称:</strong> {{ detail.siteName }}</p>
        <p><strong>现场简称:</strong> {{ detail.siteShortName }}</p>
        <p><strong>权限字段:</strong> {{ detail.siteKey }}</p>
        <p><strong>现场地址:</strong> {{ detail.address }}</p>
        <p><strong>服务线:</strong> {{ detail.serviceLine }}</p>
        <p><strong>现场图片:</strong> <img :src="detail.picture" alt="现场图片" v-if="detail.picture"></p>
        <p><strong>是否可用:</strong> {{ detail.isactive }}</p>
        <p><strong>现场经度:</strong> {{ detail.longitude }}</p>
        <p><strong>现场纬度:</strong> {{ detail.latitude }}</p>
        <p><strong>现场描述:</strong> {{ detail.description }}</p>
      </div>
      <span slot="footer" class="dialog-footer">
        <el-button @click="openDetailDialog = false">关闭</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import { listSite, getSite, delSite, addSite, updateSite } from "@/api/sites/site";

export default {
  name: "Site",
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
      // 现场管理表格数据
      siteList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 是否显示详情弹出层
      openDetailDialog: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        siteId: null,
        logo: null,
        siteName: null,
        siteShortName: null,
        siteKey: null,
        address: null,
        serviceLine: null,
        picture: null,
        isactive: null,
        longitude: null,
        latitude: null,
        description: null
      },
      // 表单参数
      form: {},
      // 详情参数
      detail: {},
      // 表单校验
      rules: {
        siteId: [
          { required: true, message: "现场ID不能为空", trigger: "blur" }
        ],
        logo: [
          { required: true, message: "现场logo不能为空", trigger: "blur" }
        ],
        siteName: [
          { required: true, message: "现场名称不能为空", trigger: "blur" }
        ],
        siteKey: [
          { required: true, message: "权限字段不能为空", trigger: "blur" }
        ],
        address: [
          { required: true, message: "现场地址不能为空", trigger: "blur" }
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
    /** 查询现场管理列表 */
    getList() {
      this.loading = true;
      listSite(this.queryParams).then(response => {
        this.siteList = response.rows;
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
        siteId: null,
        logo: null,
        siteName: null,
        siteShortName: null,
        siteKey: null,
        address: null,
        serviceLine: null,
        picture: null,
        isactive: null,
        longitude: null,
        latitude: null,
        description: null
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
      this.ids = selection.map(item => item.siteId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加现场管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const siteId = row.siteId || this.ids
      getSite(siteId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改现场管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.siteId != null) {
            updateSite(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addSite(this.form).then(response => {
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
      const siteIds = row.siteId || this.ids;
      this.$modal.confirm('是否确认删除现场管理编号为"' + siteIds + '"的数据项？').then(function() {
        return delSite(siteIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('sites/site/export', {
        ...this.queryParams
      }, `site_${new Date().getTime()}.xlsx`)
    },
    /** 详情按钮操作 */
    handleDetail(row) {
      const siteId = row.siteId || this.ids;
      getSite(siteId).then(response => {
        this.detail = response.data;
        this.openDetailDialog = true;
      });
    },
  }
};
</script>

<style scoped>
.app-container {
  padding: 20px;
}
.mb8 {
  margin-bottom: 8px;
}
</style>
