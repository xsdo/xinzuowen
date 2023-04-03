<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="是否使用" prop="isUsed">
        <el-input
          v-model="queryParams.isUsed"
          placeholder="请输入是否使用"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="备注" prop="remarks">
        <el-input
          v-model="queryParams.remarks"
          placeholder="请输入备注"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="激活码创建时间" prop="vCreatetime">
        <el-date-picker clearable
          v-model="queryParams.vCreatetime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择激活码创建时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="激活码到期时间" prop="vEndtime">
        <el-date-picker clearable
          v-model="queryParams.vEndtime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择激活码到期时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="激活码" prop="activationCode">
        <el-input
          v-model="queryParams.activationCode"
          placeholder="请输入激活码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="激活时间" prop="vUsetime">
        <el-date-picker clearable
          v-model="queryParams.vUsetime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择激活时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="激活用户id" prop="userId">
        <el-input
          v-model="queryParams.userId"
          placeholder="请输入激活用户id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="建码人" prop="createUser">
        <el-input
          v-model="queryParams.createUser"
          placeholder="请输入建码人"
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
          v-hasPermi="['users:activation:add']"
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
          v-hasPermi="['users:activation:edit']"
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
          v-hasPermi="['users:activation:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['users:activation:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="activationList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="ID" align="center" prop="id" />
      <el-table-column label="是否使用" align="center" prop="isUsed" />
      <el-table-column label="备注" align="center" prop="remarks" />
      <el-table-column label="会员类型" align="center" prop="vipType" />
      <el-table-column label="激活码创建时间" align="center" prop="vCreatetime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.vCreatetime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="激活码到期时间" align="center" prop="vEndtime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.vEndtime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="激活码" align="center" prop="activationCode" />
      <el-table-column label="激活码状态" align="center" prop="status" />
      <el-table-column label="激活时间" align="center" prop="vUsetime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.vUsetime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="激活用户id" align="center" prop="userId" />
      <el-table-column label="建码人" align="center" prop="createUser" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['users:activation:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['users:activation:remove']"
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

    <!-- 添加或修改激活码对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="是否使用" prop="isUsed">
          <el-input v-model="form.isUsed" placeholder="请输入是否使用" />
        </el-form-item>
        <el-form-item label="备注" prop="remarks">
          <el-input v-model="form.remarks" placeholder="请输入备注" />
        </el-form-item>
        <el-form-item label="激活码创建时间" prop="vCreatetime">
          <el-date-picker clearable
            v-model="form.vCreatetime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择激活码创建时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="激活码到期时间" prop="vEndtime">
          <el-date-picker clearable
            v-model="form.vEndtime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择激活码到期时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="激活码" prop="activationCode">
          <el-input v-model="form.activationCode" placeholder="请输入激活码" />
        </el-form-item>
        <el-form-item label="激活时间" prop="vUsetime">
          <el-date-picker clearable
            v-model="form.vUsetime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择激活时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="激活用户id" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入激活用户id" />
        </el-form-item>
        <el-form-item label="建码人" prop="createUser">
          <el-input v-model="form.createUser" placeholder="请输入建码人" />
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
import { listActivation, getActivation, delActivation, addActivation, updateActivation } from "@/api/users/activation";

export default {
  name: "Activation",
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
      // 激活码表格数据
      activationList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        isUsed: null,
        remarks: null,
        vipType: null,
        vCreatetime: null,
        vEndtime: null,
        activationCode: null,
        status: null,
        vUsetime: null,
        userId: null,
        createUser: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询激活码列表 */
    getList() {
      this.loading = true;
      listActivation(this.queryParams).then(response => {
        this.activationList = response.rows;
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
        id: null,
        isUsed: null,
        createTime: null,
        updateTime: null,
        remarks: null,
        vipType: null,
        vCreatetime: null,
        vEndtime: null,
        activationCode: null,
        status: null,
        vUsetime: null,
        userId: null,
        createUser: null
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
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加激活码";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getActivation(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改激活码";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateActivation(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addActivation(this.form).then(response => {
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
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除激活码编号为"' + ids + '"的数据项？').then(function() {
        return delActivation(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('users/activation/export', {
        ...this.queryParams
      }, `activation_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
